package com.ws.service;

import javax.servlet.http.HttpServletRequest;

public interface IReplyService {
	/**
	 * 
	 * @param req ��HttpServletRequest����ȡjson����comment_id ,comment
	 */
	public void addReply(HttpServletRequest req);
}
