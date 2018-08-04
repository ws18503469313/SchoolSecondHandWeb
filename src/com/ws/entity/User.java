package com.ws.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 
 * @author polunzi
 * @username 	锟矫伙拷锟斤拷
 * @password 	锟斤拷锟斤拷
 * @phone 		锟街伙拷锟�
 * @email 		锟斤拷锟斤拷
 * @date		锟矫伙拷注锟斤拷时锟斤拷
 * @role		锟斤拷色:1--锟斤拷通锟矫伙拷,2--锟斤拷锟斤拷员
 * @gods 		锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷品
 * @comments 	锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷品锟斤拷品锟斤拷   一锟皆讹拷/锟斤拷锟揭伙拷锟�
 */
@Entity
@Table(name="t_user")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User {
	private int id;
	private String username;
	private String password;
	private String address;
	private String phone;
	private String email;
	private String date;
	private int role;
	private Set<God> gods;
	private Set<Comment> comments;
	private Set<Collection> collections;
	private Set<Order> orders;
	private Set<Info> infos;
	private int state = 0;
	public User() {
		
	}

	public User(int id, String username, String password, int state) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.state = state;
	}

	public User(int id, String username, String password, String address,
			String phone, String email, int role) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.role = role;
	}
	
	public User(int id, String username, String password, String address,
			String phone, String email, String date, int role) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.role = role;
	}

	public User(int id, String username, String password, String address,
			String phone, String email, Set<God> gods, Set<Comment> comments) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.gods = gods;
		this.comments = comments;
	}
	
	public User(int id, String username, String password, String address,
			String phone, String email, Set<God> gods, Set<Comment> comments,
			Set<Collection> collections) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.gods = gods;
		this.comments = comments;
		this.collections = collections;
	}

	

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@OneToMany(mappedBy="publisher")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<God> getGods() {
		return gods;
	}
	public void setGods(Set<God> gods) {
		this.gods = gods;
	}
	@OneToMany(mappedBy="commenter")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@OneToMany(mappedBy="user")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Collection> getCollections() {
		return collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}
	@OneToMany(mappedBy="purcher")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Info> getInfos() {
		return infos;
	}

	public void setInfos(Set<Info> infos) {
		this.infos = infos;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", role=" + role + "]";
	}
	

	
	
}
