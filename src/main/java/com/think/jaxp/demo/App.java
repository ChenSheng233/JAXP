package com.think.jaxp.demo;




import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.think.jaxp.demo.util.ResourcesUtils;
import com.think.jaxp.demo.xml.hander.XmlDefaultHandler;


public class App 
{
    public static void main( String[] args ) throws IOException, ParserConfigurationException, SAXException 
    {
    	// DTD 校验
//    	DTDValidated();
    	
    	// XML namespace 支持
//    	namespaceSupport();
    	
    	// 解析 XML文档的过程中，将空白行移除
//    	ignoringElementContentWhitespace();
    	
    	resolveEntity();
    }
    
    /**
     * DTD校验
     * @throws IOException 
     */
    public static void DTDValidated() throws IOException {
    	InputStream is = ResourcesUtils.getResourceAsStream("mybatis-config.xml");
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    	
    	
    	/**
    	 * 是否进行DTD校验，默认为false。
    	 */
    	factory.setValidating(true);
    	try {
        	DocumentBuilder builder = factory.newDocumentBuilder();
        	
        	// 自定义处理类
        	XmlDefaultHandler handler = new XmlDefaultHandler();
        	builder.setEntityResolver(handler);
        	
     
        	/**
        	 * XML解析错误处理类，注意要重写解析错误的相关方法
        	 */
        	builder.setErrorHandler(handler);
        	
        	Document document = builder.parse(new InputSource(is));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		is.close();
    	}
    }

    /**
     * 在使用 JAXP解析 XML文档中，可以选择开启是否支持 namespaces功能。
     * 
     * @throws IOException
     */
    public static void namespaceSupport() throws IOException {
    	InputStream is = ResourcesUtils.getResourceAsStream("namespace.xml");
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    	
    	
    	/**
    	 * 是否启用XML namespace命名空间功能
    	 */
    	factory.setNamespaceAware(true);
    	try {
        	DocumentBuilder builder = factory.newDocumentBuilder();
        	
        	// 自定义处理类
        	XmlDefaultHandler handler = new XmlDefaultHandler();
        	builder.setEntityResolver(handler);
        	
     
        	/**
        	 * XML解析错误处理类，注意要重写解析错误的相关方法
        	 */
        	builder.setErrorHandler(handler);
        	
        	Document document = builder.parse(new InputSource(is));
        	
        	/**
        	 * 使用 namespaces功能查询文档节点
        	 */
        	NodeList nodes = document.getElementsByTagNameNS("http://www.w3.org/TR/html4/", "Title");
        	
        	/**
        	 * 如果没有开启 namespace支持，则 titleNode为 null。
        	 */
        	Node titleNode = nodes.item(0);
        	
        	// 输出 Sherlock Holmes - I
        	System.out.println(titleNode.getTextContent());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		is.close();
    	}
    }

    
    /**
     * 在使用 JAXP解析 XML文档的过程中，将空白行移除
     * @throws IOException
     */
    public static void ignoringElementContentWhitespace() throws IOException {
    	InputStream is = ResourcesUtils.getResourceAsStream("namespace.xml");
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
    	
    	// 解析 XML文档的过程中，将空白行移除
    	factory.setIgnoringElementContentWhitespace(true);
    	try {
        	DocumentBuilder builder = factory.newDocumentBuilder();
        	
        	// 自定义处理类
        	XmlDefaultHandler handler = new XmlDefaultHandler();
        	builder.setEntityResolver(handler);
        	
     
        	/**
        	 * XML解析错误处理类，注意要重写解析错误的相关方法
        	 */
        	builder.setErrorHandler(handler);
        	
        	Document document = builder.parse(new InputSource(is));
        	
       	 	XPath xpath = XPathFactory.newInstance().newXPath();
       	 	Node node = (Node)  xpath.evaluate("/configuration", document, XPathConstants.NODE);
       	 	// 不包含空白行node
       	 	System.out.println(node.getChildNodes());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		is.close();
    	}
    }
    
    
    public static void resolveEntity() throws ParserConfigurationException, SAXException, IOException {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
    	factory.setValidating(true);
    	
    	// 自定义处理类
    	XmlDefaultHandler handler = new XmlDefaultHandler();
    	DocumentBuilder builder = factory.newDocumentBuilder();
    	builder.setEntityResolver(handler);
    	builder.setErrorHandler(handler);
    	
    	
    	Document document = builder.parse(ResourcesUtils.getResourceAsStream("mybatis-config.xml"));
    }
}
