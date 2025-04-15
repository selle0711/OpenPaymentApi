// xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://www.nrf-arts.org/IXRetail/namespace" xmlns:IFSF="http://www.ifsf.org/"

// Need  xsi:noNamespaceSchemaLocation="C:\\Program Files\\Wincor Nixdorf\\Wincor Nixdorf OPI\\OPISchema\\ServiceRequest.xsd"
//          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="http://www.nrf-arts.org/IXRetail/namespace" xmlns:IFSF="http://www.ifsf.org/"
//Actuel xmlns:ns5="http://www.nrf-arts.org/IXRetail/namespace" xmlns:IFSF="http://www.ifsf.org/" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

@XmlSchema(
        namespace = "http://www.nrf-arts.org/IXRetail/namespace",
        elementFormDefault = XmlNsForm.UNQUALIFIED,
        xmlns = {
                @XmlNs(prefix="xsi", namespaceURI="http://www.w3.org/2001/XMLSchema-instance"),

                @XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema"),
                @XmlNs(prefix="IFSF", namespaceURI="http://www.ifsf.org/")
        }
)
package de.selle.opi.jaxb;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;