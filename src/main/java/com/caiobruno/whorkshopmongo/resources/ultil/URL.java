package com.caiobruno.whorkshopmongo.resources.ultil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
 
	
	public static String deCodeParam(String text) {
		
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
