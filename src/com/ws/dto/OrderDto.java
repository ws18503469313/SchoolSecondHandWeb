package com.ws.dto;

public class OrderDto {
	private int odId;
	private int godId;
	private String godname;
	private Double price;
	private String address;
	private int state;
	private String createTime;
	private String updateTime;
	public OrderDto() {
		super();
	}
	
	
	public OrderDto(int odId, int godId, String godname, Double price, String address, int state, String createTime,
			String updateTime) {
		super();
		this.odId = odId;
		this.godId = godId;
		this.godname = godname;
		this.price = price;
		this.address = address;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}


	public int getOdId() {
		return odId;
	}


	public void setOdId(int odId) {
		this.odId = odId;
	}


	public String getGodname() {
		return godname;
	}
	public void setGodname(String godname) {
		this.godname = godname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public int getGodId() {
		return godId;
	}

	public void setGodId(int godId) {
		this.godId = godId;
	}
	
	
}
