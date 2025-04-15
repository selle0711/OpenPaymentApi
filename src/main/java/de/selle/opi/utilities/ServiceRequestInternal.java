package de.selle.opi.utilities;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import de.selle.opi.jaxb.ServiceRequest;
import de.selle.opi.jaxb.ServiceRequest.PrivateData.PrinterParam;
import de.selle.opi.jaxb.ServiceRequest.PrivateData.PrinterParam.Receipt;
import de.selle.opi.jaxb.ServiceRequest.PrivateData.SignatureParam;
import de.selle.opi.jaxb.ServiceRequest.PrivateData.SignatureParam.GetConfirmation;
import de.selle.utilities.JAXBHelper;
import jakarta.xml.bind.JAXBException;

public final class ServiceRequestInternal extends ServiceRequest {
	private static final Logger logger = LogManager.getLogger(ServiceRequestInternal.class);
	private static final String APPLICATION_SENDER = "ECR_OPI_INGENICO";
	private static final String MERCHANT = "Merchant";
	private static final String ADMINISTRATION = "Administration";
	private static final String CUSTOMER = "Customer";
	private static final String PRINTER = "Printer";
	private static final String PRINTER_RECEIPT = "PrinterReceipt";
	private static final String YES = "yes";
	
	private final ServiceRequestType serviceRequestType;
	
	public ServiceRequestInternal() {
		throw new RuntimeException("Konstruktor darf nicht aufgerufen werden");
	}
	
	public ServiceRequestInternal(final ServiceRequestBuilder serviceRequestBuilder) {
		validateServiceRequestBuilder(serviceRequestBuilder);
		this.serviceRequestType = serviceRequestBuilder.getServiceRequestType();
		setRequestType(serviceRequestType.name());
		setWorkstationID(serviceRequestBuilder.getWorkstationId());
		setApplicationSender(APPLICATION_SENDER);
		setRequestID(serviceRequestBuilder.getRequestID());
		setPOSdata(buildPosData());
		setPrivateData(buildPrivateData());
		logger.debug(getRequestType()+"-ServiceRequest-Object is constructed with RequestID: "+getRequestID());
	}
	
	private void validateServiceRequestBuilder(ServiceRequestBuilder serviceRequestBuilder) {
		if (serviceRequestBuilder == null) {
			throw new IllegalArgumentException("Kein Builder übergeben");
		}
		if(serviceRequestBuilder.getWorkstationId() == null) {
			throw new IllegalArgumentException("Keine WorkstationId angegeben");
		}
		if(serviceRequestBuilder.getRequestID() == 0) {
			throw new IllegalArgumentException("Keine RequestId angegeben");
		}
		if (serviceRequestBuilder.getServiceRequestType() == null) {
			throw new IllegalArgumentException("Kein ServiceRequestType angegeben");
		}
	}

	private POSdata buildPosData() {
		final POSdata posDdata = new POSdata();
		try {
			posDdata.setPOSTimeStamp(JAXBHelper.getXMLGregorianCalendar(new Date()));
		} catch (final DatatypeConfigurationException e) {
			logger.error("Fehler beim Erstellen des POS-Timestamps", e);
		}
		return posDdata;
	}
	
	private PrivateData buildPrivateData() {
		final PrivateData privateData = new PrivateData();
		if (serviceRequestType == ServiceRequestType.Login) {
			final Map<String, Map<String, String>> printerParams = new TreeMap<>(Map.of(PRINTER,
					Map.of(MERCHANT, YES, ADMINISTRATION, YES), PRINTER_RECEIPT, Map.of(CUSTOMER, YES)));
			printerParams.forEach((type, map) -> privateData.getPrinterParam().add(buildPrinterParam(type, map)));
			
			privateData.setSignatureParam(buildSignatureParam());
		}
		return privateData;
	}

	private PrinterParam buildPrinterParam(String type, Map<String, String> map) {
		final PrinterParam printerParam = new PrinterParam();
		printerParam.setType(type);
		map.forEach((key, value) -> printerParam.getReceipt().add(new Receipt(key, value)));
		return printerParam;
	}
	
	private SignatureParam buildSignatureParam() {
		final SignatureParam signatureParam = new SignatureParam();
		final GetConfirmation confirmation = new GetConfirmation();
		confirmation.setTimeout(180);
		confirmation.setValue(YES);
		signatureParam.setGetConfirmation(confirmation);
		return signatureParam;
	}
	
	public String getXml() {
		try {
			return JAXBHelper.marshalToFormattedXML(ServiceRequest.class, this, null, "ServiceRequest");
		} catch (JAXBException | SAXException e) {
			logger.error("Fehler beim Konvertierung des Obkjektes zu XML", e);
			return null;
		}
	}
}