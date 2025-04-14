//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2025.04.09 um 02:27:13 PM CEST 
//


package de.selle.opi.jaxb;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.materna.opi.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.materna.opi.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CardServiceRequest }
     * 
     */
    public CardServiceRequest createCardServiceRequest() {
        return new CardServiceRequest();
    }

    /**
     * Create an instance of {@link ServiceResponse }
     * 
     */
    public ServiceResponse createServiceResponse() {
        return new ServiceResponse();
    }

    /**
     * Create an instance of {@link ServiceRequest }
     * 
     */
    public ServiceRequest createServiceRequest() {
        return new ServiceRequest();
    }

    /**
     * Create an instance of {@link ServiceRequest.PrivateData }
     * 
     */
    public ServiceRequest.PrivateData createServiceRequestPrivateData() {
        return new ServiceRequest.PrivateData();
    }

    /**
     * Create an instance of {@link ServiceRequest.PrivateData.SignatureParam }
     * 
     */
    public ServiceRequest.PrivateData.SignatureParam createServiceRequestPrivateDataSignatureParam() {
        return new ServiceRequest.PrivateData.SignatureParam();
    }

    /**
     * Create an instance of {@link ServiceRequest.PrivateData.PrinterParam }
     * 
     */
    public ServiceRequest.PrivateData.PrinterParam createServiceRequestPrivateDataPrinterParam() {
        return new ServiceRequest.PrivateData.PrinterParam();
    }

    /**
     * Create an instance of {@link CardServiceRequest.POSdata }
     * 
     */
    public CardServiceRequest.POSdata createCardServiceRequestPOSdata() {
        return new CardServiceRequest.POSdata();
    }

    /**
     * Create an instance of {@link CardServiceRequest.TotalAmount }
     * 
     */
    public CardServiceRequest.TotalAmount createCardServiceRequestTotalAmount() {
        return new CardServiceRequest.TotalAmount();
    }

    /**
     * Create an instance of {@link ServiceResponse.Terminal }
     * 
     */
    public ServiceResponse.Terminal createServiceResponseTerminal() {
        return new ServiceResponse.Terminal();
    }

    /**
     * Create an instance of {@link ServiceRequest.POSdata }
     * 
     */
    public ServiceRequest.POSdata createServiceRequestPOSdata() {
        return new ServiceRequest.POSdata();
    }

    /**
     * Create an instance of {@link ServiceRequest.PrivateData.SignatureParam.GetConfirmation }
     * 
     */
    public ServiceRequest.PrivateData.SignatureParam.GetConfirmation createServiceRequestPrivateDataSignatureParamGetConfirmation() {
        return new ServiceRequest.PrivateData.SignatureParam.GetConfirmation();
    }

    /**
     * Create an instance of {@link ServiceRequest.PrivateData.PrinterParam.Receipt }
     * 
     */
    public ServiceRequest.PrivateData.PrinterParam.Receipt createServiceRequestPrivateDataPrinterParamReceipt() {
        return new ServiceRequest.PrivateData.PrinterParam.Receipt();
    }

}
