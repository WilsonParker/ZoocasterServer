package com.graction.lumi.util.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.graction.lumi.data.DataStorage;
import com.graction.lumi.data.DataStorage.Path;
import com.graction.lumi.util.log.HLogger;
import com.graction.lumi.util.log.HLogger.LogType;


/*
 * 	Not Complete
 * 	Not Used
 */
public class XmlParserForSAX{
	private final HLogger logger = new HLogger(XmlParserForSAX.class);
	private static final XmlParserForSAX instance = new XmlParserForSAX();
	private final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	private SAXParser saxParser;

	public static XmlParserForSAX getInstance() {
		return instance;
	}
	
	// Parse xml file to T 
	public <T> T parseXmlToObject(Class<?> cls, String fileName) {
		return parseXmlToObject(cls, DataStorage.Path_Directory + Path.PATH_DIR_XML, fileName);
	}
	
	public <T> T parseXmlToObject(Class<?> cls, String path, String fileName) {
		T t = null;
		try {
			saxParser = saxParserFactory.newSAXParser();
			File xmlFile = new File(path + fileName);
			saxParser.parse(xmlFile, new SAXHandler());
		} catch (Exception e) {
			logger.log(LogType.ERROR, "xml init error", e);
		}
		return t;
	}
	
	
	
	
	public class SAXHandler extends DefaultHandler{

		@Override
		public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
			// TODO Auto-generated method stub
			return super.resolveEntity(publicId, systemId);
		}

		@Override
		public void notationDecl(String name, String publicId, String systemId) throws SAXException {
			// TODO Auto-generated method stub
			super.notationDecl(name, publicId, systemId);
		}

		@Override
		public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.unparsedEntityDecl(name, publicId, systemId, notationName);
		}

		@Override
		public void setDocumentLocator(Locator locator) {
			// TODO Auto-generated method stub
			super.setDocumentLocator(locator);
		}

		@Override
		public void startDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.startDocument();
		}

		@Override
		public void endDocument() throws SAXException {
			// TODO Auto-generated method stub
			super.endDocument();
		}

		@Override
		public void startPrefixMapping(String prefix, String uri) throws SAXException {
			// TODO Auto-generated method stub
			super.startPrefixMapping(prefix, uri);
		}

		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
			// TODO Auto-generated method stub
			super.endPrefixMapping(prefix);
		}

		StringBuilder sb = new StringBuilder();
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			// TODO Auto-generated method stub
			super.startElement(uri, localName, qName, attributes);
			System.out.printf("qName : %s, localName : %s, uri : %s\n", qName, localName, uri);
			for(int i=0; i<attributes.getLength(); i++) {
				System.out.printf("Attribute name : %s, value : %s\n",attributes.getQName(i),attributes.getValue(i));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);
		}

		@Override
		public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			super.ignorableWhitespace(ch, start, length);
		}

		@Override
		public void processingInstruction(String target, String data) throws SAXException {
			// TODO Auto-generated method stub
			super.processingInstruction(target, data);
		}

		@Override
		public void skippedEntity(String name) throws SAXException {
			// TODO Auto-generated method stub
			super.skippedEntity(name);
		}

		@Override
		public void warning(SAXParseException e) throws SAXException {
			// TODO Auto-generated method stub
			super.warning(e);
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
			// TODO Auto-generated method stub
			super.error(e);
		}

		@Override
		public void fatalError(SAXParseException e) throws SAXException {
			// TODO Auto-generated method stub
			super.fatalError(e);
		}
		
	}
}
