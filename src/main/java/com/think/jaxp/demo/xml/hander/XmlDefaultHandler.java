package com.think.jaxp.demo.xml.hander;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.think.jaxp.demo.util.ResourcesUtils;

public class XmlDefaultHandler extends DefaultHandler{

	
	/**
	 * 文档开始解析时回调触发
	 */
	@Override
	public void startDocument() throws SAXException {

	}
	
	/**
	 * 文档结束解析时回调触发
	 */
	@Override
	public void endDocument() throws SAXException {

	}


	/**
	 * 开始解析文档节点时回调触发，XML文档中的每一个节点都会回调触发
	 * @param uri
	 * @param localName
	 * @param qName XML中的节点名称
	 * @param attributes 当前节点的属性
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

	}

	
	
	/**
	 * 结束解析文档节点时回调触发，XML文档中的每一个节点都会回调触发
	 * @param uri
	 * @param localName
	 * @param qName XML中的节点名称
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

	}

	
	/**
	 * 
	 */
	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
		InputSource source = new InputSource(ResourcesUtils.getResourceAsStream("mybatis-3-config.dtd"));
    	source.setPublicId("-//mybatis.org//DTD Config 3.0//EN");
    	source.setSystemId("http://mybatis.org/dtd/mybatis-3-config.dtd");
    	return source;
	}

	/**
	 * 如果没有实现error方法，在对文档进行处理即使有错误发生。也不会抛出错误
	 */
	@Override
	public void error(SAXParseException e) throws SAXException {
		e.printStackTrace();
		throw e;
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		throw e;
	}

}
