package com.ws.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ws.entity.Comment;

public interface ICommnetService {
	/**
	 * 
	 * @param comment	�ӽ��洫����������
	 * @param id		���ĸ���Ʒ������,������һ����ƷID
	 * @param req		��req�л�ȡ˭���۵�
	 */
	public void addCommnet(String comment,int id,HttpServletRequest req);

	public List<Comment> checkComments(int id);
}
