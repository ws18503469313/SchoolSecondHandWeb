package com.ws.dto;

public class InfoDto {
	private int infoId = 0;
	private int godId = 0;
	private int orderId = 0;
	private String content ="";
	private String date = "";
	private int state = 0;
	public InfoDto() {
		super();
	}
	public static void main(String[] args) {
		InfoDto dto = new InfoDto();
		System.out.println(dto);
	}
	
	public InfoDto(int infoId, int orderId, String content, String date, int state) {
		super();
		this.infoId = infoId;
		this.orderId = orderId;
		this.content = content;
		this.date = date;
		this.state = state;
	}
	public InfoDto(int infoId, String content, String date, int state) {
		super();
		this.infoId = infoId;
		this.content = content;
		this.date = date;
		this.state = state;
	}
	public InfoDto(int infoId, int godId, int orderId, String content, String date, int state) {
		super();
		this.infoId = infoId;
		this.godId = godId;
		this.orderId = orderId;
		this.content = content;
		this.date = date;
		this.state = state;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public int getGodId() {
		return godId;
	}
	public void setGodId(int godId) {
		this.godId = godId;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "InfoDto [infoId=" + infoId + ", godId=" + godId + ", orderId=" + orderId + ", content=" + content
				+ ", date=" + date + ", state=" + state + "]";
	}
	
	
	
}
