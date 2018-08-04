package com.ws.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ws.dao.ICommentDao;
import com.ws.dao.IReplyDao;
import com.ws.entity.Comment;
import com.ws.entity.Reply;
import com.ws.service.IReplyService;
import com.ws.util.DateUtil;

@Service("replyService")
public class ReplyService implements IReplyService{
	private ICommentDao commentDao;
	private IReplyDao replyDao;
	@Resource
	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}
	@Resource
	public void setReplyDao(IReplyDao replyDao) {
		this.replyDao = replyDao;
	}


	public void addReply(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		int comment_id = Integer.parseInt(req.getParameter("comment_id"));
		Comment comment = commentDao.load(comment_id);
		String content = req.getParameter("reply");
		System.out.println("comment_id"+comment_id+"reply"+content);
		String date = DateUtil.getNowTime();
		Reply reply = new Reply(comment, content, date);
		replyDao.add(reply);
	}

}
