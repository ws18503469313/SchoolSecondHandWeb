package com.ws.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ws.dao.ICommentDao;
import com.ws.dao.IGodDao;
import com.ws.entity.Comment;
import com.ws.entity.God;
import com.ws.entity.User;
import com.ws.exception.MyRuntimeException;
import com.ws.service.ICommnetService;
import com.ws.util.DateUtil;
@Service("commentService")
public class CommentService implements ICommnetService{
	private ICommentDao commentDao;
	private IGodDao godDao;
	@Resource
	public void setCommentDao(ICommentDao commentDao) {
		this.commentDao = commentDao;
	}
	@Resource
	public void setGodDao(IGodDao godDao) {
		this.godDao = godDao;
	}


	public void addCommnet(String comment, int id, HttpServletRequest req) {
		// TODO Auto-generated method stub
		User user = (User)req.getSession().getAttribute("loginUser");
		God god = godDao.load(id);
		if(user == null){
			throw new MyRuntimeException("登录阿!");
		}
		if(god.getPublisher().getId() == user.getId()){
			throw new MyRuntimeException("这是你自己的商品啊!");
		}else{
			Comment cmt = new Comment(user, comment, DateUtil.getNowTime(), god);
			commentDao.add(cmt);
		}
	}
	public List<Comment> checkComments(int id) {
		// TODO Auto-generated method stub
		String hql = "from Comment c where c.commenter.id = ?";
		return commentDao.checkComment(hql,id);
	}

}
