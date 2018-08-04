package com.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author polunzi
 * @comment   对于哪条评论的回复    一对多/多的一端
 * @content	     回复内容
 * @date	     回复时间
 */

@Entity
@Table(name="t_replies")
public class Reply {
	private int id;
	private Comment comment;
	private String content;
	private String date;
	public Reply() {
		
	}
	
	public Reply(Comment comment, String content, String date) {
		
		this.comment = comment;
		this.content = content;
		this.date = date;
	}

	public Reply(int id, Comment comment, String content, String date) {
	
		this.id = id;
		this.comment = comment;
		this.content = content;
		this.date = date;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="comt_id")
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
