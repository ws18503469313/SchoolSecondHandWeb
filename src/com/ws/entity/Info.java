package com.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="t_info")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Info {
	private int id;
	private User user;
	private String contt;
	private String date;
	private int state = 0; //0:刚下单|1:已发货|2:已收货|3:已取消
	private Order order;
	public Info() {
		super();
	}
	
	public Info(int id, User user, String contt, String date, int state, Order order) {
		super();
		this.id = id;
		this.user = user;
		this.contt = contt;
		this.date = date;
		this.state = state;
		this.order = order;
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
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContt() {
		return contt;
	}
	public void setContt(String contt) {
		this.contt = contt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@OneToOne
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Info [id=" + id + ", contt=" + contt + ", date=" + date
				+ "]";
	}
	
}
