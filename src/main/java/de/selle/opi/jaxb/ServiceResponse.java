//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2025.04.09 um 02:27:13 PM CEST
//

package de.selle.opi.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="Terminal">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="TerminalID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PrivateData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="WorkstationID" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="RequestType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RequestID" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="OverallResult" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "terminal", "privateData" })
@XmlRootElement(name = "ServiceResponse")
public class ServiceResponse {

    @XmlElement(name = "Terminal", required = true)
    protected ServiceResponse.Terminal terminal;

    @XmlElement(name = "PrivateData", required = true)
    protected String privateData;

    @XmlAttribute(name = "WorkstationID")
    protected Byte workstationID;

    @XmlAttribute(name = "RequestType")
    protected String requestType;

    @XmlAttribute(name = "RequestID")
    protected Byte requestID;

    @XmlAttribute(name = "OverallResult")
    protected String overallResult;

    /**
     * Ruft den Wert der terminal-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link Terminal }
     */
    public Terminal getTerminal() {
	return this.terminal;
    }

    /**
     * Legt den Wert der terminal-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link Terminal }
     */
    public void setTerminal(final Terminal value) {
	this.terminal = value;
    }

    /**
     * Ruft den Wert der privateData-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getPrivateData() {
	return this.privateData;
    }

    /**
     * Legt den Wert der privateData-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     */
    public void setPrivateData(final String value) {
	this.privateData = value;
    }

    /**
     * Ruft den Wert der workstationID-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link Byte }
     */
    public Byte getWorkstationID() {
	return this.workstationID;
    }

    /**
     * Legt den Wert der workstationID-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link Byte }
     */
    public void setWorkstationID(final Byte value) {
	this.workstationID = value;
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
     * Ruft den Wert der requestID-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link Byte }
     */
    public Byte getRequestID() {
	return this.requestID;
    }

    /**
     * Legt den Wert der requestID-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link Byte }
     */
    public void setRequestID(final Byte value) {
	this.requestID = value;
    }

    /**
     * Ruft den Wert der overallResult-Eigenschaft ab.
     * 
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getOverallResult() {
	return this.overallResult;
    }

    /**
     * Legt den Wert der overallResult-Eigenschaft fest.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     */
    public void setOverallResult(final String value) {
	this.overallResult = value;
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
     *       &lt;attribute name="TerminalID" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    public static class Terminal {

	@XmlValue
	protected String value;

	@XmlAttribute(name = "TerminalID")
	protected Integer terminalID;

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
	 * Ruft den Wert der terminalID-Eigenschaft ab.
	 * 
	 * @return
	 *         possible object is
	 *         {@link Integer }
	 */
	public Integer getTerminalID() {
	    return this.terminalID;
	}

	/**
	 * Legt den Wert der terminalID-Eigenschaft fest.
	 * 
	 * @param value
	 *              allowed object is
	 *              {@link Integer }
	 */
	public void setTerminalID(final Integer value) {
	    this.terminalID = value;
	}

    }

}
