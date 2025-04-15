package de.selle.opi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.selle.utilities.JAXBHelper;

public class OpiServer {
	private static final Logger logger = LogManager.getLogger(OpiServer.class);

	private final int port;

	public OpiServer(final int port) {
		this.port = port;
	}

	public void start() {
		try (ServerSocket serverSocket = new ServerSocket(this.port)) {
			logger.info("OPI-Server gestartet und wartet auf Verbindungen....");
			while (true) {
				try (final Socket clientSocket = serverSocket.accept();
						final BufferedReader reader = new BufferedReader(
								new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8))) {
					logger.info("Client verbunden...");

					final StringBuilder xmlResponse = new StringBuilder();
					final char[] buffer = new char[65535];
					reader.read(buffer);
					for (final char letter : buffer) {
						if (Character.isLetterOrDigit(letter) || Character.isWhitespace(letter)
								|| JAXBHelper.isPunctuation(letter)) {
							xmlResponse.append(letter);
						}
					}
					logger.warn(xmlResponse.toString());

				} catch (final Exception e) {
					logger.error("", e);
				}
			}
		} catch (final Exception e) {
			logger.error("", e);
		}
	}
}