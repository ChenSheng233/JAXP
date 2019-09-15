package com.think.dog;


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.think.dog.util.ResourceUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SAXException, IOException, ParserConfigurationException
    {
//        XMLReader  xr = XMLReaderFactory.createXMLReader();
//        SaxDefaultHandler handler = new SaxDefaultHandler();
//        xr.setContentHandler(handler);
//        xr.setErrorHandler(handler);
//        
//        
//       xr.parse(new InputSource(ResourceUtils.getResourceAsStream("namespace.xml")));
    
       
       // DTD 文档校验
//       DTD();
       
       // 命名空间
       namespaces();
    }
    
    
    public static void DTD() throws ParserConfigurationException, SAXException, IOException {
    	SaxDefaultHandler handler = new SaxDefaultHandler();
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 是否验证xml文件，这个验证是DTD验证
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        
        builder.setEntityResolver(handler);
        builder.setErrorHandler(handler);
        
        builder.parse(ResourceUtils.getResourceAsStream("dtd.xml"));
    }
    
    /**
     * xmlns命名空间的作用
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void namespaces() throws ParserConfigurationException, SAXException, IOException {
    	SaxDefaultHandler handler = new SaxDefaultHandler();
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	
    	// XML文档的命名空间支持
    	factory.setNamespaceAware(true);
    	DocumentBuilder builder = factory.newDocumentBuilder();
        
        
        builder.setEntityResolver(handler);
        builder.setErrorHandler(handler);
        
        Document document = builder.parse(ResourceUtils.getResourceAsStream("namespace.xml"));
        NodeList nodeList = document.getElementsByTagName("Title");
        System.out.println(nodeList.item(0).getTextContent());
        NodeList nodes = document.getElementsByTagNameNS("http://www.w3.org/TR/html4/", "Title");
        System.out.println(nodes.item(0).getTextContent());
    }
}
