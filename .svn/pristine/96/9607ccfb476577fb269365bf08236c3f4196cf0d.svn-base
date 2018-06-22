package com.graction.lumi.util.parser;

import com.graction.lumi.util.log.HLogger;
import com.graction.lumi.util.log.HLogger.LogType;

public class XmlParserForJAXB {
	private static final XmlParserForJAXB instance = new XmlParserForJAXB();
	private final HLogger logger = new HLogger(XmlParserForJAXB.class);

	public XmlParserForJAXB() {
	}

	public static XmlParserForJAXB getInstance() {
		return instance;
	}
	
	// Parse xml file to T 
	public <T> T parseXmlToObject(Class<?> cls, String fileName) {
		T t = null;
		try {
			// JAXBContext jc = JAXBContext.newInstance(cls);
			// Unmarshaller unMarshaller = jc.createUnmarshaller();
			// t = (T) unMarshaller.unmarshal(new File(DataStorage.Path_Directory + Path.PATH_DIR_XML + fileName));
		} catch (Exception e) {
			logger.log(LogType.ERROR, "xml init error", e);
		}
		return t;
	}

}
