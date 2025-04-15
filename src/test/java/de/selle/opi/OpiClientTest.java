package de.selle.opi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.selle.opi.jaxb.ServiceResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpiClientTest {
	private static final Logger logger = LogManager.getLogger(OpiClientTest.class);

	private final static String TERMINAL_IP = "192.168.178.76";

	private final static int TERMINEL_PORT = 5577;
	
	private final static int SERVER_PORT = 5578;

	

	private OpiClient opiClient;
	
	private final Thread serverThread = new Thread(() -> {
		final OpiServer server = new OpiServer(SERVER_PORT);
		server.start();
	});

	@BeforeEach 
	public void setUp() {
		logger.info("Setup OPI-Client");
		opiClient = new OpiClient(TERMINAL_IP, TERMINEL_PORT);
	}
	
	@Test
	public void login() {
		try {
			final ServiceResponse response = this.opiClient.login();
			assertNotNull(response);
			logger.info("Login-Result: "+response.getOverallResult());
			logger.info("Termial-ID: "+response.getTerminal().getTerminalID());
			assertEquals("Success", response.getOverallResult(), "Die Strings sind nicht identisch");
		} catch (final Exception e) {
			logger.error("", e);
			fail(e.getMessage());
		}
	}

//	@Test
//	public void payment() {
//		try {
//			serverThread.start();
//			
//			final CardServiceRequest cardServiceRequest = new CardServiceRequest();
//			cardServiceRequest.setWorkstationID("00000001");
//			cardServiceRequest.setRequestType(CardServiceRequestType.CardPayment.name());
//			cardServiceRequest.setApplicationSender(APPLICATION_SENDER);
//			cardServiceRequest.setRequestID(14);
//			final POSdata posData = new POSdata();
//			posData.setTransactionNumber(1);
//			posData.setManualPAN("false");
//			posData.setPOSTimeStamp(JAXBHelper.getXMLGregorianCalendar(new Date()));
//			cardServiceRequest.setPOSdata(posData);
//			final TotalAmount amount = new TotalAmount();
//			amount.setCurrency("EUR");
//			amount.setValue(0.01f);
//			cardServiceRequest.setTotalAmount(amount);
//			this.opiClient = new OpiClient(TERMINAL_IP, TERMINEL_PORT);
//			final String response = opiClient.sendMessage(JAXBHelper.marshalToFormattedXML(CardServiceRequest.class, cardServiceRequest, null, "CardRequest"));
//			logger.debug(response);
//			assertNotNull(response);
//			
//			serverThread.interrupt();
//		} catch (final Exception e) {
//			logger.error("", e);
//			fail(e.getMessage());
//		}
//		
//	}
}