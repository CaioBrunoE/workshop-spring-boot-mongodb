package com.caiobruno.whorkshopmongo.resources.ultil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
 
	
	public static String deCodeParam(String text) {
		
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date converteDate(String textDate,Date defalutValue ) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defalutValue;
		}
		
	}
}
