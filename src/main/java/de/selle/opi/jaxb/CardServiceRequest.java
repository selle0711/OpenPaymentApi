//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2025.04.09 um 02:27:13 PM CEST
//

package de.selle.opi.jaxb;

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
 *                   &lt;element name="ManualPAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TotalAmount">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                 &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
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
@XmlType(name = "", propOrder = { "poSdata", "totalAmount" })
@XmlRootElement(name = "CardServiceRequest")
public class CardServiceRequest {

    @XmlElement(name = "POSdata", required = true)
    protected CardServiceRequest.POSdata poSdata;

    @XmlElement(name = "TotalAmount", required = true)
    protected CardServiceRequest.TotalAmount totalAmount;

    @XmlAttribute(name = "RequestID")
    protected int requestID;

    /**
     * Identifies the logical workstation (associated to the socket) sending the
     * request: it can be only one at a time, sending only one request at a time.
     * Usually the POS (more than one POS might be present); also an OPT
     * identifies a logical workstation; in case of CRIND (usually two sides, one
     * per filling position of the pump) it counts as two logical workstations.
     * NOTE: Not renamed to avoid recoding in the interface implementation
     * already in place.
     * <strong>Required</strong>
     */
    @XmlAttribute(name = "WorkstationID")
    protected String workstationID;

    /**
     * Identifies the application sending the request. Used only for information
     * logging purpose. (Unlikely more than one POS is present at one cash desk!)
     * <strong>Optional</strong>
     */
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
     * Ruft den Wert der totalAmount-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link TotalAmount }
     */
    public TotalAmount getTotalAmount() {
	return this.totalAmount;
    }

    /**
     * Legt den Wert der totalAmount-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link TotalAmount }
     */
    public void setTotalAmount(final TotalAmount value) {
	this.totalAmount = value;
    }

    /**
     * Ruft den Wert der requestID-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link Byte }
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
     *         &lt;element name="ManualPAN" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TransactionNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "posTimeStamp", "manualPAN", "transactionNumber" })
    public static class POSdata {

	@XmlElement(name = "POSTimeStamp", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar posTimeStamp;

	@XmlElement(name = "ManualPAN", required = true)
	protected String manualPAN;

	@XmlElement(name = "TransactionNumber")
	protected int transactionNumber;

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

	/**
	 * Ruft den Wert der manualPAN-Eigenschaft ab.
	 * 
	 * @return
	 *         possible object is
	 *         {@link String }
	 */
	public String getManualPAN() {
	    return this.manualPAN;
	}

	/**
	 * Legt den Wert der manualPAN-Eigenschaft fest.
	 * 
	 * @param value
	 *              allowed object is
	 *              {@link String }
	 */
	public void setManualPAN(final String value) {
	    this.manualPAN = value;
	}

	/**
	 * Ruft den Wert der transactionNumber-Eigenschaft ab.
	 */
	public int getTransactionNumber() {
	    return this.transactionNumber;
	}

	/**
	 * Legt den Wert der transactionNumber-Eigenschaft fest.
	 */
	public void setTransactionNumber(final int value) {
	    this.transactionNumber = value;
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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    public static class TotalAmount {

	@XmlValue
	protected float value;

	@XmlAttribute(name = "Currency")
	protected String currency;

	/**
	 * Ruft den Wert der value-Eigenschaft ab.
	 */
	public float getValue() {
	    return this.value;
	}

	/**
	 * Legt den Wert der value-Eigenschaft fest.
	 */
	public void setValue(final float value) {
	    this.value = value;
	}

	/**
	 * Ruft den Wert der currency-Eigenschaft ab.
	 * 
	 * @return
	 *         possible object is
	 *         {@link String }
	 */
	public String getCurrency() {
	    return this.currency;
	}

	/**
	 * Legt den Wert der currency-Eigenschaft fest.
	 * 
	 * @param value
	 *              allowed object is
	 *              {@link String }
	 */
	public void setCurrency(final String value) {
	    this.currency = value;
	}

    }

}
