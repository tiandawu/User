package com.tdw.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlDaoUtils {

	private static Document dom = null;
	private static String path = XmlDaoUtils.class.getClassLoader()
			.getResource("users.xml").getPath();

	private XmlDaoUtils() {
	}

	static {
		try {
			SAXReader reader = new SAXReader();
			dom = reader.read(path);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取xml的document
	 * 
	 * @return document
	 */
	public static Document getDom() {
		return dom;
	}

	/**
	 * 回写数据到xml文件
	 */
	public static void refXml() {
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(path),
					OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
