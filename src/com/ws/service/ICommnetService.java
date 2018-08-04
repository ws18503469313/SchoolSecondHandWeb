package com.ws.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ws.entity.Comment;

public interface ICommnetService {
	/**
	 * 
	 * @param comment	从界面传过来的评论
	 * @param id		给哪个商品的评论,传过来一个商品ID
	 * @param req		从req中获取谁评论的
	 */
	public void addCommnet(String comment,int id,HttpServletRequest req);

	public List<Comment> checkComments(int id);
}
