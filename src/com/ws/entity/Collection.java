package com.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="t_collection")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Collection {
	private int id;
	private User user;
	private God god;
	private String date;
	
	
	public Collection() {
		
	}
	public Collection(User user, God god) {
		
		this.user = user;
		this.god = god;
	}
	public Collection(int id, User user, God god) {
		
		this.id = id;
		this.user = user;
		this.god = god;
	}
	
	public Collection(User user, God god, String date) {
		
		
		this.user = user;
		this.god = god;
		this.date = date;
	}
	
	public Collection(int id, User user, God god, String date) {
		
		this.id = id;
		this.user = user;
		this.god = god;
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
	@JoinColumn(name="collector_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="god_id")
	public God getGod() {
		return god;
	}
	public void setGod(God god) {
		this.god = god;
	}
	@Column(name="date",length=50,nullable=false)
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
