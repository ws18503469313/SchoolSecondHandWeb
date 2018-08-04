package com.ws.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 
 * @author polunzi
 * @JDKBase64Encode		��һ��String����
 * @JDKBase64Decode		��һ��String����
 */
public class ImoocBase64 {
	public static void main(String[] args) {
		String str = "123456";
		String decode = JDKBase64Encode(str);
		System.out.println(decode);
	}
	public static String JDKBase64Encode(String str){
		BASE64Encoder encoder = new BASE64Encoder();
		String encode = "";
		try {
			encode = encoder.encode(str.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encode;
	}
	public static String JDKBase64Decode(String str){
		BASE64Decoder decoder = new BASE64Decoder();
		String decode = "";
		try {
			byte[] decodes = decoder.decodeBuffer(str);
			decode = new String(decodes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decode;
	}
	
}
