package com.ws.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author polunzi
 * @publisher ��������  һ�Զ�/���һ��
 * @name  ��Ʒ���
 * @disc  ��Ʒ����
 * @price ��Ʒ�۸�
 * @type  ��Ʒ�Ĵ������
 * @date  ��Ʒ����ʱ��
 * @clickTime	��Ʒ�ĵ������
 * @imgs  ��Ʒ������ͼƬ
 * @state ��Ʒ�ĳ���״̬	0-�ϼ�/1-�۳�/2-�¼�
 * @comments ��Ʒ������  һ�Զ�/һ��һ��
 */

@Entity
@Table(name="t_gods")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class God {
	private int id;
	private User publisher;
	private String name;
	private String disc;
	private Double price;
	private String type;
	private String date;
	private int clickTime;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private int state; // 0--正常
	private Order order;
	private Set<Comment> comments;
	private Set<Collection> collecteds;
	public God() {

	}
	
	

	public God(int id, int godId) {
		super();
		this.id = id;
		this.order = new Order();
		order.setId(godId);
	}

	public God(int id, User publisher, String name, String disc, Double price,
			String type, String date, String img1, String img2, String img3,
			String img4, int state) {
		
		this.id = id;
		this.publisher = publisher;
		this.name = name;
		this.disc = disc;
		this.price = price;
		this.type = type;
		this.date = date;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.state = state;
	}
	
	


	public God(int godId, int uId,String email) {
		super();
		this.id = godId;
		this.publisher = new User();
		this.publisher.setId(uId);
		this.publisher.setEmail(email);
	}



	public God(int id, User publisher, String name, String disc, Double price,
			String type, String date, int clickTime, String img1, String img2,
			String img3, String img4, int state) {
		super();
		this.id = id;
		this.publisher = publisher;
		this.name = name;
		this.disc = disc;
		this.price = price;
		this.type = type;
		this.date = date;
		this.clickTime = clickTime;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.state = state;
	}

	public God(int id, User publisher, String name, String disc, Double price,
			String date, String img1, String img2, String img3, String img4,
			Set<Comment> comments) {
		
		this.id = id;
		this.publisher = publisher;
		this.name = name;
		this.disc = disc;
		this.price = price;
		this.date = date;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.comments = comments;
	}
	
	public God(int id, User publisher, String name, String disc, Double price,
			String type, String date, String img1, String img2, String img3,
			String img4, int state, Set<Comment> comments,
			Set<Collection> collecteds) {
		super();
		this.id = id;
		this.publisher = publisher;
		this.name = name;
		this.disc = disc;
		this.price = price;
		this.type = type;
		this.date = date;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.state = state;
		this.comments = comments;
		this.collecteds = collecteds;
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
	@JoinColumn(name="pid")
	public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getClickTime() {
		return clickTime;
	}
	public void setClickTime(int clickTime) {
		this.clickTime = clickTime;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	@OneToOne(mappedBy="god")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@OneToMany(mappedBy="god")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@OneToMany(mappedBy="god")
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public Set<Collection> getCollecteds() {
		return collecteds;
	}

	public void setCollecteds(Set<Collection> collecteds) {
		this.collecteds = collecteds;
	}

	@Override
	public String toString() {
		return "God [id=" + id + ", name=" + name + ", disc=" + disc
				+ ", price=" + price + ", type=" + type + ", date=" + date
				+ ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3
				+ ", img4=" + img4 + ", state=" + state + "]";
	}
	
	
	
}
