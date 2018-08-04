package com.ws.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author polunzi
 * @commenter  ������۵���		һ�Զ�/���һ��
 * @comment   ��������
 * @date 	     ������۵�ʱ��
 * @god		     �ĸ���Ʒ������	  һ�Զ�/���һ��
 * @replys	     �����۵Ļظ�(����) һ�Զ�/һ��һ��
 */

@Entity
@Table(name="t_comments")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Comment {
	private int id;
	private User commenter;
	private String comment;
	private String date;
	private God god;
	private Set<Reply> replies;
	public Comment() {

	}
	public Comment(int id, User commenter, String comment, String date, God god) {
	
		this.id = id;
		this.commenter = commenter;
		this.comment = comment;
		this.date = date;
		this.god = god;
	}
	public Comment(int id, User commenter, String comment, String date,
			God god, Set<Reply> replies) {
		
		this.id = id;
		this.commenter = commenter;
		this.comment = comment;
		this.date = date;
		this.god = god;
		this.replies = replies;
	}
	public Comment(User commenter, String comment, String date, God god) {
		super();
		this.commenter = commenter;
		this.comment = comment;
		this.date = date;
		this.god = god;
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
	@JoinColumn(name="comter_id")
	public User getCommenter() {
		return commenter;
	}
	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@ManyToOne
	@JoinColumn(name="god_id")
	public God getGod() {
		return god;
	}
	public void setGod(God god) {
		this.god = god;
	}
	@OneToMany(mappedBy="comment")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", commenter=" + commenter + ", comment="
				+ comment + ", date=" + date + ", god=" + god + ", replies="
				+ replies + "]";
	}
	
	
}
