package de.selle.utilities;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * Marshalling und Unmarshalling von JAXB Objekten
 *
 * @author croettge
 */
public final class JAXBHelper {

	private static final Logger logger = LogManager.getLogger(JAXBHelper.class);

    private final static SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	/**
	 * Wandelt ein Datum als String in XMLGregorianCalendar um
	 *
	 * @param myDate
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar getXMLGregorianCalendar(final Date myDate) throws DatatypeConfigurationException {
		if (myDate == null) {
			return null;
		}

		final GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(myDate);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

	}

	/**
	 * Wandelt ein XMLGregorianCalendar in ein Date um
	 *
	 * @param xmlDate
	 * @return
	 */
	public static Date getDateFromXMLGregorianCalendar(final XMLGregorianCalendar xmlDate) {
		if (xmlDate == null) {
			return null;
		}
		return xmlDate.toGregorianCalendar().getTime();
	}


	 /**
     * Konvertiert eine Java-Klasse nach XML und validiert gegen ein vorhandenes
     * XSD. Das XML wird nicht formattiert.
     *
     * @param <T>
     * @param clazz
     * @param object
     * @param xsdFile
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    public static <T> String marshalToXML(final Class<T> clazz, final T object, final String xsdFile) throws JAXBException, SAXException {
	return marshalToXML(clazz, object, xsdFile, false);
    }

    /**
     * Konvertiert eine Java-Klasse nach XML und validiert gegen ein vorhandenes
     * XSD. Das XML wird formattiert erzeugt.
     *
     * @param <T>
     * @param clazz
     * @param object
     * @param xsdFile
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    public static <T> String marshalToFormattedXML(final Class<T> clazz, final T object, final String xsdFile) throws JAXBException, SAXException {
	return marshalToXML(clazz, object, xsdFile, true);
    }

    private static <T> String marshalToXML(final Class<T> clazz, final T object, final String xsdFile, final boolean formattedOutput) throws JAXBException, SAXException {
	final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	Schema xsdSchema = null;
	if (xsdFile != null) {
	    logger.debug("Versuche Schema-File '" + xsdFile + "' zu finden.");
	    final URL xsdUrl = clazz.getResource(xsdFile);
	    if (xsdUrl != null) {
		xsdSchema = schemaFactory.newSchema(xsdUrl);
	    } else {
		logger.warn("Schema-File '" + xsdFile + "' nicht �ber clazz.getResource() gefunden. Versuche clazz.getResouceAsStrem()");
		final InputStream is = clazz.getClassLoader().getResourceAsStream(xsdFile);
		if (is != null) {
		    xsdSchema = schemaFactory.newSchema(new StreamSource(is));
		} else {
		    logger.error("Schema-Datei '" + xsdFile + " nicht gefunden'");
		}
	    }
	}

	StringWriter writer = new StringWriter();
	JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "C:\\\\Program Files\\\\Wincor Nixdorf\\\\Wincor Nixdorf OPI\\\\OPISchema\\\\ServiceRequest.xsd");
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.valueOf(formattedOutput));
	jaxbMarshaller.setSchema(xsdSchema);
	jaxbMarshaller.marshal(object, writer);
	return writer.toString();
    }

    /**
     * Generiert aus einem XML-String eine Java-Klasse. Das XML wird dabei anhand
     * des XSD validiert.
     *
     * @param <T>
     * @param clazz
     * @param xml
     * @param xsdFile
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    public static <T> T unmarshallToJaxb(final Class<T> clazz, final String xml, final String xsdFile) throws JAXBException, SAXException {
	final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	Schema xsdSchema = null;
	if (xsdFile != null) {
	    logger.debug("Versuche Schema-File '" + xsdFile + "' zu finden.");
	    final URL xsdUrl = clazz.getResource(xsdFile);
	    if (xsdUrl != null) {
		xsdSchema = schemaFactory.newSchema(xsdUrl);
	    } else {
		logger.warn("Schema-File '" + xsdFile + "' nicht �ber clazz.getResource() gefunden. Versuche clazz.getResouceAsStrem()");
		final InputStream is = clazz.getClassLoader().getResourceAsStream(xsdFile);
		if (is != null) {
		    xsdSchema = schemaFactory.newSchema(new StreamSource(is));
		} else {
		    logger.error("Schema-Datei '" + xsdFile + " nicht gefunden'");
		}
	    }
	}
	JAXBContext jc = JAXBContext.newInstance(clazz);
	Unmarshaller unmarshaller = jc.createUnmarshaller();
	unmarshaller.setSchema(xsdSchema);
	T obj = clazz.cast(unmarshaller.unmarshal(new StringReader(xml)));
	return obj;
    }

    /**
     * Generiert aus einer XML-Datei eine Java-Klasse. Das XML wird dabei anhand des
     * XSD validiert.
     *
     * @param <T>
     * @param clazz
     * @param xml
     * @param xsdFile
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    public static <T> T unmarshallFileToJaxb(final Class<T> clazz, final File xmlFile, final String xsdFile) throws JAXBException, SAXException {
	final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	Schema xsdSchema = schemaFactory.newSchema(clazz.getResource(xsdFile));
	JAXBContext jc = JAXBContext.newInstance(clazz);
	Unmarshaller unmarshaller = jc.createUnmarshaller();
	unmarshaller.setSchema(xsdSchema);
	T obj = clazz.cast(unmarshaller.unmarshal(xmlFile));
	return obj;
    }

    /**
     * Generiert aus einer XML-Datei eine Java-Klasse. Das XML wird dabei anhand des
     * XSD validiert.
     *
     * @param <T>
     * @param clazz
     * @param xml
     * @param xsdFile
     * @return
     * @throws JAXBException
     * @throws SAXException
     */
    public static <T> T unmarshallInputStreamToJaxb(final Class<T> clazz, final InputStream inputStream, final String xsdFile) throws JAXBException, SAXException {
	Schema xsdSchema = sf.newSchema(clazz.getResource(xsdFile));
	JAXBContext jc = JAXBContext.newInstance(clazz);
	Unmarshaller unmarshaller = jc.createUnmarshaller();
	unmarshaller.setSchema(xsdSchema);
	T obj = clazz.cast(unmarshaller.unmarshal(inputStream));
	return obj;
    }

}
