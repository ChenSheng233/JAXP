package com.think.jaxp.demo.util;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DocumentUtils {

	public static Document getDocumentAsStream(DocumentBuilder builder,String name) throws SAXException, IOException, ParserConfigurationException {

		return builder.parse(new InputSource(ResourcesUtils.getResourceAsStream(name)));
	}
	
	
}
