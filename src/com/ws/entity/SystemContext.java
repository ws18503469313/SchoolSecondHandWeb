package com.ws.entity;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * SystemContext	�����߳�  �洢ҳ��(pageIndex)�Ͷ�����(pageSize) ������ݵĹ���
 *
 */
public class SystemContext {
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<HttpServletRequest> req = new ThreadLocal<HttpServletRequest>();
	
	public static int getPageIndex() {
		return pageIndex.get();
	}
	
	public static void setPageIndex(int _pageIndex) {
		pageIndex.set(_pageIndex);
	}
	
	public static void removePageIndex() {
		pageIndex.remove();
	}
	
	public static int getPageSize() {
		return pageSize.get();
	}
	
	public static void setPageSize(int _pageSize) {
		pageSize.set(_pageSize);
	}
	
	public static void removePageSize() {
		pageSize.remove();
	}

	public static HttpServletRequest getReq() {
		return req.get();
	}
	public static void setRequest(HttpServletRequest request) {  
	    req.set(request);  
	 }  
	
	public static void removeHttpServletRequest(){
		req.remove();
	}
	

}
