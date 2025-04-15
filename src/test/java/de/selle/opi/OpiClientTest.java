package de.selle.opi;

import de.selle.opi.jaxb.ServiceRequest;
import de.selle.opi.utilities.ServiceRequestType;
import de.selle.utilities.JAXBHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OpiClientTest {
    private static final Logger logger = LogManager.getLogger(OpiClientTest.class);

    private final static String TERMINAL_IP = "192.168.178.76";

    private final static int TERMINEL_PORT = 5577;

    private static final String APPLICATION_SENDER = "ECR_OPI_INGENICO";

    private OpiClient opiClient;

    @BeforeEach
    public void login() {
        try {
            final ServiceRequest loginRequest = new ServiceRequest();
            loginRequest.setWorkstationID("00000001");
            loginRequest.setRequestType(ServiceRequestType.Login.name());
            loginRequest.setApplicationSender(APPLICATION_SENDER);
            loginRequest.setRequestID(Byte.valueOf((byte) 12));

            final ServiceRequest.PrivateData privateData = new ServiceRequest.PrivateData();
            final ServiceRequest.PrivateData.PrinterParam printerParam = new ServiceRequest.PrivateData.PrinterParam();
            printerParam.setType("Printer");
            printerParam.getReceipt().add(new ServiceRequest.PrivateData.PrinterParam.Receipt("Merchant", "yes"));
            printerParam.getReceipt().add(new ServiceRequest.PrivateData.PrinterParam.Receipt("Administration", "yes"));

            final ServiceRequest.PrivateData.PrinterParam printerReceiptParam = new ServiceRequest.PrivateData.PrinterParam();
            printerReceiptParam.setType("PrinterReceipt");
            printerReceiptParam.getReceipt().add(new ServiceRequest.PrivateData.PrinterParam.Receipt("Customer", "yes"));

            privateData.getPrinterParam().add(printerParam);
            privateData.getPrinterParam().add(printerReceiptParam);

            final ServiceRequest.PrivateData.SignatureParam signatureParam = new ServiceRequest.PrivateData.SignatureParam();
            final ServiceRequest.PrivateData.SignatureParam.GetConfirmation confirmation = new ServiceRequest.PrivateData.SignatureParam.GetConfirmation();
            confirmation.setTimeout(Short.valueOf((short) 180));
            confirmation.setValue("yes");
            signatureParam.setGetConfirmation(confirmation);

            privateData.setSignatureParam(signatureParam);

            final ServiceRequest.POSdata sdata = new ServiceRequest.POSdata();
            sdata.setPOSTimeStamp(JAXBHelper.getXMLGregorianCalendar(new Date()));

            loginRequest.setPOSdata(sdata);
            loginRequest.setPrivateData(privateData);

            this.opiClient = new OpiClient(TERMINAL_IP, TERMINEL_PORT);
            final String response = this.opiClient.sendMessage(JAXBHelper.marshalToFormattedXML(ServiceRequest.class, loginRequest, null));
            logger.debug(response);
            assertNotNull(response);
        } catch (final Exception e) {
            logger.error("", e);
            fail(e.getMessage());
        }
    }

    @Test
    public void payment() {

    }
}