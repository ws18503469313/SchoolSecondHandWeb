package com.ws.service;

import javax.servlet.http.HttpServletRequest;

public interface IReplyService {
	/**
	 * 
	 * @param req 从HttpServletRequest中提取json参数comment_id ,comment
	 */
	public void addReply(HttpServletRequest req);
}
