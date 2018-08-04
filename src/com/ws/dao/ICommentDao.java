package com.ws.dao;

import java.util.List;

import com.ws.dto.CommentDto;
import com.ws.entity.Comment;

public interface ICommentDao extends IBaseDao<Comment>{
	
	public List<Comment> checkComment(String hql, int id);

	public List<CommentDto> loadCommentAndReply(int id);

}
