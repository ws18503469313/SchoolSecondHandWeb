package com.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * @title		���ű���
 * @content		��������
 * @date		���ŷ���ʱ��
 * @filename	�ļ���(������)
 * @author polunzi
 *
 */
@Entity
@Table(name="t_notice")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Notice {
	private int id;
	private String title;
	private String content;
	private String date;
	private String filename;
	public Notice() {
		
	}
	public Notice(int id, String title, String content, String date,
			String filename) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.filename = filename;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
