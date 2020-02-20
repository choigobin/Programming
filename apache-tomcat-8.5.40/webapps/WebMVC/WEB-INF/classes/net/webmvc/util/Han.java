package net.webmvc.util;

import java.io.UnsupportedEncodingException;

public class Han {
	public static String toHan(String str) {
		try {
			return new String(str.getBytes("8859_1"),"UTF-8");
		}
		catch(UnsupportedEncodingException e) {
			return null;
		}
	}
	
	public static String toEng(String str){
		try {
			return new String(str.getBytes("UTF-8"),"8859_1");
		}
		catch(UnsupportedEncodingException e) {
			return null;
		}
	}

}
