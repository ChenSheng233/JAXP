package com.think.jaxp.demo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.think.jaxp.demo.util.DocumentUtils;
import com.think.jaxp.demo.xml.hander.XmlDefaultHandler;

public class XPathApplication {
	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		Document document = getDocument();
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();

		Node configuration = (Node) xpath.evaluate("/configuration", document, XPathConstants.NODE);
		System.out.print(configuration);

		
		Node property = (Node) xpath.evaluate("properties", configuration,XPathConstants.NODE);
		System.out.print(property);
	}

	private static Document getDocument() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		XmlDefaultHandler hander = new XmlDefaultHandler();
		builder.setEntityResolver(hander);
		builder.setEntityResolver(hander);

		return DocumentUtils.getDocumentAsStream(builder, "mybatis-config.xml");
	}
}
