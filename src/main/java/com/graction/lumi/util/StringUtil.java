package com.graction.lumi.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.StringTokenizer;

public class StringUtil {
	public final static String ENCODING_UTF_8 = "UTF-8"
								, ENCODING_ASCCI = "ASCCI"
								, ENCODING_ISO_8859_1 = "ISO-8859-1"
								; 
	public final static Charset ISO_8859_1 = Charset.forName(ENCODING_ISO_8859_1), UTF_8 = Charset.forName(ENCODING_UTF_8),
			DEFAULT = UTF_8;

	public static String getDefaultString(String s, String def) {
		if (nullCheck(s))
			return def;
		else
			return s;
	}

	public static boolean nullCheck(String s) {
		if (s == null)
			return true;
		s = s.trim();
		if (s.equals("") || s.equals("null"))
			return true;
		else
			return false;
	}

	public static boolean nullCheck(int i, boolean minus) {
		boolean result = false;
		if (minus)
			result = i > 0 ? false : true;
		else
			result = i == 0 ? true : false;
		return result;
	}

	// List to String
	public static <E> String createString(String root, String child, Collection<E> items) {
		StringBuilder sb = new StringBuilder();
		sb.append("{" + root + " : { " + child + " [");
		for (E e : items)
			sb.append(e.toString() + ",");
		sb.append("]}}");
		return sb.toString();
	}
	
	public static <E> String createString(String root, Collection<E> items) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ " + root + " [");
		for (E e : items)
			sb.append(e.toString() + ",");
		sb.append("]}}");
		return sb.toString();
	}

	public static <E> String createString(String name, E[] es) {
		StringBuilder sb = new StringBuilder();
		sb.append("{" + name + " : [ ");
		for (E e : es)
			sb.append(e.toString() + ",");
		sb.append("]}");
		return sb.toString();
	}

	public static String requestParamEncoding(String str, Charset charset) {
		return new String(str.getBytes(ISO_8859_1), charset);
	}

	public static String requestParamEncoding(String str) {
		return requestParamEncoding(str, DEFAULT);
	}
	
	public static String urlEncoding(String str) throws UnsupportedEncodingException {
		return urlEncoding(str, ENCODING_UTF_8);
	}
	
	public static String urlEncoding(String str, String encode) throws UnsupportedEncodingException {
		return URLDecoder.decode(str, encode);
	}

	public static boolean contains(String s1, String s2, String delim) {
		StringTokenizer tokenizer = new StringTokenizer(s2, delim);
		while (tokenizer.hasMoreTokens()) {
			if (s1.contains(tokenizer.nextToken()))
				return true;
		}
		return false;
	}
	
	public static boolean contains(String s1, String s2) {
		return contains(s1, s2," ");
	}
}