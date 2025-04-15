package de.selle.opi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.selle.opi.jaxb.ServiceResponse;
import de.selle.opi.utilities.ServiceRequestBuilder;
import de.selle.opi.utilities.ServiceRequestType;
import de.selle.utilities.JAXBHelper;

/**
 * OPI-Client zum Senden von Nachrichten zum EC-Terminal
 *
 * @author rgesell
 */
public class OpiClient {
    private static final Logger logger = LogManager.getLogger(OpiClient.class);

    private final String serverIp;
    private final int port;
    private final int timeOut;
    
    /**
     * Client für das OPI-Protokoll zum EC-Terminal
     * 
     * @param serverIp IP des Terminals
     * @param port Port des Terminals
     */
    public OpiClient(final String serverIp, final int port) {
    	this(serverIp, port, 180);
    }

    /**
     * Client für das OPI-Protokoll zum EC-Terminal
     * 
     * @param serverIp IP des Terminals
     * @param port Port des Terminals
     * @param timeOut Zeit in Sekunden, die gewartet werden soll, bis zum Abbruch der Kommunikation (Standard 180s)
     */
    public OpiClient(final String serverIp, final int port, final int timeOut) {
        super();
        this.serverIp = serverIp;
        this.port = port;
        this.timeOut = timeOut;
    }
    
    /**
     * Führt den Login zum EC-Terminal aus und gibt sein Antwort zurück 
     * @return {@link ServiceResponse}
     */
    public ServiceResponse login() {
    	logger.info("-> login()");
    	try {
    		final String loginXml = new ServiceRequestBuilder(ServiceRequestType.Login).setRequestID(1 + new Random().nextInt(99)).setWorkstationId("00000001").build().getXml();
    		String xmlResponse = sendMessage(loginXml);
    		
    		// Namespace manuell hinzufügen
    		xmlResponse = xmlResponse.replace("<ServiceResponse ", "<ServiceResponse xsi:noNamespaceSchemaLocation=\"C:\\\\Program Files\\\\Wincor Nixdorf\\\\Wincor Nixdorf OPI\\\\OPISchema\\\\ServiceRequest.xsd\" xmlns=\"http://www.nrf-arts.org/IXRetail/namespace\" xmlns:IFSF=\"http://www.ifsf.org/\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
            logger.warn(xmlResponse);
            return JAXBHelper.unmarshallToJaxb(ServiceResponse.class, xmlResponse, null);
    	} catch (final Exception e) {
    		logger.error("", e);
    		return null;
    	} finally {
    		logger.info("<- login()");
		}
    }

    private String sendMessage(String xmlData) {
        xmlData = xmlData.replaceAll("ns5:", "");
        xmlData = xmlData.replaceAll(":ns5", "");
        logger.debug("sendMessage:\n{}", xmlData);
        try (final Socket socket = new Socket(this.serverIp, this.port);
             final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {

            socket.setSoTimeout(timeOut * 1000); // 180s Timeout

            // Sende die Nachricht
            socket.getOutputStream().write(new byte[]{0x00,0x00,0x03, 0x5f});
            socket.getOutputStream().write(xmlData.getBytes());
            logger.debug("Nachricht gesendet");

            // Empfange die Antwort
            final StringBuilder xmlResponse = new StringBuilder();
            final char[] buffer = new char[65535];
            final int countLetter = in.read(buffer);
            for (int i = 0; i < countLetter; i++) {
            	final char letter = buffer[i];
            	if (Character.isLetterOrDigit(letter) || Character.isWhitespace(letter) || JAXBHelper.isPunctuation(letter)) {
            		xmlResponse.append(letter);
            	}
            }
            
            return xmlResponse.toString();

        } catch (final Exception e) {
            logger.error("", e);
            return null;
        }
    }
}
