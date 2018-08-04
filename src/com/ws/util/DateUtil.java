package com.ws.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author polunzi
 * @getNowDay	���ظ�ʽ���ĵ�ǰ���ڵ�String
 * @getNowTime	���ظ�ʽ���ĵ�ǰʱ���String
 */
public class DateUtil {
	public static void main(String[] args) {
		System.out.println(getNowDay());
		System.out.println(getNowTime());
	}
	public static String getNowDay(){
		Date nowTime=new Date(); 
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
		String date = time.format(nowTime);
		return date;
	}
	public static String getNowTime(){
		Date nowTime=new Date(); 
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String date = time.format(nowTime);
		return date;
	}
}
