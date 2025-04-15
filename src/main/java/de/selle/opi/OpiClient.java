package de.selle.opi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public OpiClient(final String serverIp, final int port) {
        super();
        this.serverIp = serverIp;
        this.port = port;
    }

    public String sendMessage(String xmlData) {
        xmlData = xmlData.replaceAll("ns5:", "");
        xmlData = xmlData.replaceAll(":ns5", "");
        logger.debug("sendMessage:\n{}", xmlData);
        try (final Socket socket = new Socket(this.serverIp, this.port);
             final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {

            socket.setSoTimeout(180 * 1000); // 180s Timeout

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
            
//            final ServiceResponse response = JAXBHelper.unmarshallToJaxb(ServiceResponse.class, xmlResponse.toString(), null);
//            logger.warn(response.getRequestID());

            return xmlResponse.toString();

        } catch (final Exception e) {
            logger.error("", e);
            return null;
        }
    }
}
