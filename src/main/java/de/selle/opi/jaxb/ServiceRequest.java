//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2025.04.09 um 02:27:13 PM CEST
//

package de.selle.opi.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * <p>
 * Java-Klasse f�r anonymous complex type.
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POSdata">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="POSTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PrivateData">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PrinterParam" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Receipt" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SignatureParam">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="GetConfirmation">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="Timeout" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="RequestID" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="WorkstationID" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="ApplicationSender" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RequestType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "poSdata", "privateData" })
@XmlRootElement(name = "ServiceRequest")
public class ServiceRequest {

    @XmlElement(name = "POSdata", required = true)
    protected ServiceRequest.POSdata poSdata;

    @XmlElement(name = "PrivateData", required = true)
    protected ServiceRequest.PrivateData privateData;

    @XmlAttribute(name = "RequestID")
    protected int requestID;

    /**
     * Identifies the logical workstation (associated to the socket)
     * sending the request: it can be only one at a time, sending only one
     * request at a time.
     * Usually the POS (more than one POS might be present); also an
     * OPT identifies a logical workstation; in case of CRIND (usually two
     * sides, one per filling position of the pump) it counts as two logical
     * workstations.
     * NOTE: Not renamed to avoid recoding in the interface
     * implementation already in place.
     */
    @XmlAttribute(name = "WorkstationID")
    protected String workstationID;

    @XmlAttribute(name = "ApplicationSender")
    protected String applicationSender;

    @XmlAttribute(name = "RequestType")
    protected String requestType;

    /**
     * Ruft den Wert der poSdata-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link POSdata }
     */
    public POSdata getPOSdata() {
	return this.poSdata;
    }

    /**
     * Legt den Wert der poSdata-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link POSdata }
     */
    public void setPOSdata(final POSdata value) {
	this.poSdata = value;
    }

    /**
     * Ruft den Wert der privateData-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link PrivateData }
     */
    public PrivateData getPrivateData() {
	return this.privateData;
    }

    /**
     * Legt den Wert der privateData-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link PrivateData }
     */
    public void setPrivateData(final PrivateData value) {
	this.privateData = value;
    }

    /**
     * Ruft den Wert der requestID-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link int }
     */
    public int getRequestID() {
	return this.requestID;
    }

    /**
     * Legt den Wert der requestID-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link int }
     */
    public void setRequestID(final int value) {
	this.requestID = value;
    }

    /**
     * Ruft den Wert der workstationID-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getWorkstationID() {
	return this.workstationID;
    }

    /**
     * Legt den Wert der workstationID-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     */
    public void setWorkstationID(final String value) {
	this.workstationID = value;
    }

    /**
     * Ruft den Wert der applicationSender-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getApplicationSender() {
	return this.applicationSender;
    }

    /**
     * Legt den Wert der applicationSender-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     */
    public void setApplicationSender(final String value) {
	this.applicationSender = value;
    }

    /**
     * Ruft den Wert der requestType-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getRequestType() {
	return this.requestType;
    }

    /**
     * Legt den Wert der requestType-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     */
    public void setRequestType(final String value) {
	this.requestType = value;
    }

    /**
     * <p>
     * Java-Klasse f�r anonymous complex type.
     * <p>
     * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="POSTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "posTimeStamp" })
    public static class POSdata {

	@XmlElement(name = "POSTimeStamp", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar posTimeStamp;

	/**
	 * Ruft den Wert der posTimeStamp-Eigenschaft ab.
	 * 
	 * @return
	 *         possible object is
	 *         {@link XMLGregorianCalendar }
	 */
	public XMLGregorianCalendar getPOSTimeStamp() {
	    return this.posTimeStamp;
	}

	/**
	 * Legt den Wert der posTimeStamp-Eigenschaft fest.
	 * 
	 * @param value
	 *              allowed object is
	 *              {@link XMLGregorianCalendar }
	 */
	public void setPOSTimeStamp(final XMLGregorianCalendar value) {
	    this.posTimeStamp = value;
	}

    }

    /**
     * <p>
     * Java-Klasse f�r anonymous complex type.
     * <p>
     * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PrinterParam" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Receipt" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SignatureParam">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="GetConfirmation">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="Timeout" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "printerParam", "signatureParam" })
    public static class PrivateData {

	@XmlElement(name = "PrinterParam")
	protected List<PrinterParam> printerParam;

	@XmlElement(name = "SignatureParam", required = true)
	protected ServiceRequest.PrivateData.SignatureParam signatureParam;

	/**
	 * Gets the value of the printerParam property.
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the printerParam property.
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPrinterParam().add(newItem);
	 * </pre>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link PrinterParam }
	 */
	public List<PrinterParam> getPrinterParam() {
	    if (this.printerParam == null) {
		this.printerParam = new ArrayList<>();
	    }
	    return this.printerParam;
	}

	/**
	 * Ruft den Wert der signatureParam-Eigenschaft ab.
	 * 
	 * @return
	 *         possible object is
	 *         {@link SignatureParam }
	 */
	public SignatureParam getSignatureParam() {
	    return this.signatureParam;
	}

	/**
	 * Legt den Wert der signatureParam-Eigenschaft fest.
	 * 
	 * @param value
	 *              allowed object is
	 *              {@link SignatureParam }
	 */
	public void setSignatureParam(final SignatureParam value) {
	    this.signatureParam = value;
	}

	/**
	 * <p>
	 * Java-Klasse f�r anonymous complex type.
	 * <p>
	 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="Receipt" maxOccurs="unbounded" minOccurs="0">
	 *           &lt;complexType>
	 *             &lt;simpleContent>
	 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
	 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *               &lt;/extension>
	 *             &lt;/simpleContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "receipt" })
	public static class PrinterParam {

	    @XmlElement(name = "Receipt")
	    protected List<Receipt> receipt;

	    @XmlAttribute(name = "Type")
	    protected String type;

	    /**
	     * Gets the value of the receipt property.
	     * <p>
	     * This accessor method returns a reference to the live list,
	     * not a snapshot. Therefore any modification you make to the
	     * returned list will be present inside the JAXB object.
	     * This is why there is not a <CODE>set</CODE> method for the receipt property.
	     * <p>
	     * For example, to add a new item, do as follows:
	     * 
	     * <pre>
	     * getReceipt().add(newItem);
	     * </pre>
	     * <p>
	     * Objects of the following type(s) are allowed in the list
	     * {@link Receipt }
	     */
	    public List<Receipt> getReceipt() {
		if (this.receipt == null) {
		    this.receipt = new ArrayList<>();
		}
		return this.receipt;
	    }

	    /**
	     * Ruft den Wert der type-Eigenschaft ab.
	     * 
	     * @return
	     *         possible object is
	     *         {@link String }
	     */
	    public String getType() {
		return this.type;
	    }

	    /**
	     * Legt den Wert der type-Eigenschaft fest.
	     * 
	     * @param value
	     *              allowed object is
	     *              {@link String }
	     */
	    public void setType(final String value) {
		this.type = value;
	    }

	    /**
	     * <p>
	     * Java-Klasse f�r anonymous complex type.
	     * <p>
	     * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
	     * 
	     * <pre>
	     * &lt;complexType>
	     *   &lt;simpleContent>
	     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
	     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
	     *     &lt;/extension>
	     *   &lt;/simpleContent>
	     * &lt;/complexType>
	     * </pre>
	     */
	    @XmlAccessorType(XmlAccessType.FIELD)
	    @XmlType(name = "", propOrder = { "value" })
	    public static class Receipt {

		public Receipt(final String type, final String value) {
		    this.type = type;
		    this.value = value;
		}

		public Receipt() {
		}

		@XmlValue
		protected String value;

		@XmlAttribute(name = "Type")
		protected String type;

		/**
		 * Ruft den Wert der value-Eigenschaft ab.
		 * 
		 * @return
		 *         possible object is
		 *         {@link String }
		 */
		public String getValue() {
		    return this.value;
		}

		/**
		 * Legt den Wert der value-Eigenschaft fest.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link String }
		 */
		public void setValue(final String value) {
		    this.value = value;
		}

		/**
		 * Ruft den Wert der type-Eigenschaft ab.
		 * 
		 * @return
		 *         possible object is
		 *         {@link String }
		 */
		public String getType() {
		    return this.type;
		}

		/**
		 * Legt den Wert der type-Eigenschaft fest.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link String }
		 */
		public void setType(final String value) {
		    this.type = value;
		}

	    }

	}

	/**
	 * <p>
	 * Java-Klasse f�r anonymous complex type.
	 * <p>
	 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="GetConfirmation">
	 *           &lt;complexType>
	 *             &lt;simpleContent>
	 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
	 *                 &lt;attribute name="Timeout" type="{http://www.w3.org/2001/XMLSchema}short" />
	 *               &lt;/extension>
	 *             &lt;/simpleContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "getConfirmation" })
	public static class SignatureParam {

	    @XmlElement(name = "GetConfirmation", required = true)
	    protected ServiceRequest.PrivateData.SignatureParam.GetConfirmation getConfirmation;

	    /**
	     * Ruft den Wert der getConfirmation-Eigenschaft ab.
	     * 
	     * @return
	     *         possible object is
	     *         {@link GetConfirmation }
	     */
	    public GetConfirmation getGetConfirmation() {
		return this.getConfirmation;
	    }

	    /**
	     * Legt den Wert der getConfirmation-Eigenschaft fest.
	     * 
	     * @param value
	     *              allowed object is
	     *              {@link GetConfirmation }
	     */
	    public void setGetConfirmation(final GetConfirmation value) {
		this.getConfirmation = value;
	    }

	    /**
	     * <p>
	     * Java-Klasse f�r anonymous complex type.
	     * <p>
	     * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
	     * 
	     * <pre>
	     * &lt;complexType>
	     *   &lt;simpleContent>
	     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
	     *       &lt;attribute name="Timeout" type="{http://www.w3.org/2001/XMLSchema}short" />
	     *     &lt;/extension>
	     *   &lt;/simpleContent>
	     * &lt;/complexType>
	     * </pre>
	     */
	    @XmlAccessorType(XmlAccessType.FIELD)
	    @XmlType(name = "", propOrder = { "value" })
	    public static class GetConfirmation {

		@XmlValue
		protected String value;

		@XmlAttribute(name = "Timeout")
		protected int timeout;

		/**
		 * Ruft den Wert der value-Eigenschaft ab.
		 * 
		 * @return
		 *         possible object is
		 *         {@link String }
		 */
		public String getValue() {
		    return this.value;
		}

		/**
		 * Legt den Wert der value-Eigenschaft fest.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link String }
		 */
		public void setValue(final String value) {
		    this.value = value;
		}

		/**
		 * Ruft den Wert der timeout-Eigenschaft ab.
		 * 
		 * @return
		 *         possible object is
		 *         {@link int }
		 */
		public int getTimeout() {
		    return this.timeout;
		}

		/**
		 * Legt den Wert der timeout-Eigenschaft fest.
		 * 
		 * @param value
		 *              allowed object is
		 *              {@link int }
		 */
		public void setTimeout(final int value) {
		    this.timeout = value;
		}

	    }

	}

    }

}
