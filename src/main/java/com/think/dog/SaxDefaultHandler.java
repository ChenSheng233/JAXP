package com.think.dog;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxDefaultHandler extends DefaultHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public SaxDefaultHandler() {
		super();
	}

	@Override
	public void startDocument() throws SAXException {
		logger.info("startDocument");
	}

	@Override
	public void endDocument() throws SAXException {
		logger.info("endDocument");
	}
	
	/**
	 * @param uri
	 * @param localName 
	 * @param qName 节点名称
	 * @param Attributes 节点属性
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// 当前节点名称
		logger.debug("element node:"+qName);
		for(int i = 0;i<attributes.getLength();i++) {
			String uri2 = attributes.getURI(i);
			String key = attributes.getQName(i);
			String value = attributes.getValue(i);
			logger.debug(uri2);
			logger.debug(key);
			logger.debug(value);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		logger.error(e.getMessage());
		throw e;
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		logger.error(e.getMessage());
		throw e;
	}

	public void characters(char ch[], int start, int length) {
		System.out.print("Characters:    \"");
		for (int i = start; i < start + length; i++) {
			switch (ch[i]) {
			case '\\':
				System.out.print("\\\\");
				break;
			case '"':
				System.out.print("\\\"");
				break;
			case '\n':
				System.out.print("\\n");
				break;
			case '\r':
				System.out.print("\\r");
				break;
			case '\t':
				System.out.print("\\t");
				break;
			default:
				System.out.print(ch[i]);
				break;
			}
		}
		System.out.print("\"\n");
	}

}