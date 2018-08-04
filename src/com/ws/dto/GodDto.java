package com.ws.dto;

public class GodDto {
	private int id;
	private String username;
	private String godname;
	private String address;
	private String disc;
	private Double price; 
	private String date;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private int userId;
	private int clickTime;
	private String phone;
	private String type;
	private int state;
	public GodDto() {
		super();
	}
	
	public GodDto(int id, String username, String godname, String address, String disc, Double price, String date,
			String img1) {
		super();
		this.id = id;
		this.username = username;
		this.godname = godname;
		this.address = address;
		this.disc = disc;
		this.price = price;
		this.date = date;
		this.img1 = img1;
	}

	public GodDto(int id, String username, String godname, String address, String disc, Double price, String date,
			String img1, String img2, String img3, String img4, int userId, int clickTime, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.godname = godname;
		this.address = address;
		this.disc = disc;
		this.price = price;
		this.date = date;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.userId = userId;
		this.clickTime = clickTime;
		this.phone = phone;
	}
	
	public GodDto(int id, String username, String godname, String address, String disc, Double price, String date,
			String img1, String img2, String img3, String img4, int userId, int clickTime, String phone, String type,
			int state) {
		super();
		this.id = id;
		this.username = username;
		this.godname = godname;
		this.address = address;
		this.disc = disc;
		this.price = price;
		this.date = date;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.userId = userId;
		this.clickTime = clickTime;
		this.phone = phone;
		this.type = type;
		this.state = state;
	}

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
	public String getGodname() {
		return godname;
	}
	public void setGodname(String godname) {
		this.godname = godname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClickTime() {
		return clickTime;
	}

	public void setClickTime(int clickTime) {
		this.clickTime = clickTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "godDto [id=" + id + ", username=" + username + ", godname=" + godname + ", address=" + address
				+ ", disc=" + disc + ", price=" + price + ", date=" + date + ", img1=" + img1 + "]";
	}
	
	
}
