package com.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order {
	private int id;
	private God god;
	private User purcher;
	private int state = 0; //0-未发货/1-发货/2-收货
	private String address;
	private String create_date;
	private String update_date;
	private String comment;
	private Info info;
	public Order() {
		super();
	}
	
	public Order(int id, God god, User purcher, int state, String address,
			String create_date, String update_date, String comment) {
		super();
		this.id = id;
		this.god = god;
		this.purcher = purcher;
		this.state = state;
		this.address = address;
		this.create_date = create_date;
		this.update_date = update_date;
		this.comment = comment;
	}
	
	public Order(int id, int purcherId, int godPublisherId,int state,String godname) {
		super();
		this.id = id;
		this.purcher =new User();
		this.purcher.setId(purcherId);
		this.god = new God();
		this.god.setPublisher(new User());
		this.god.getPublisher().setId(godPublisherId);
		this.state = state;
		this.god.setName(godname);
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
	@JoinColumn(name="pucher_id")
	public User getPurcher() {
		return purcher;
	}
	public void setPurcher(User purcher) {
		this.purcher = purcher;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@OneToOne
	@JoinColumn(name="god_id")
	public God getGod() {
		return god;
	}

	public void setGod(God god) {
		this.god = god;
	}
	@OneToOne(mappedBy="order")
	public Info getInfo() {
		return info;
	}
	
	public void setInfo(Info info) {
		this.info = info;
	}
	
}
