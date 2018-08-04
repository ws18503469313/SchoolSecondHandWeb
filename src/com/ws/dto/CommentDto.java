package com.ws.dto;

public class CommentDto {
	private int commentId;
	private int cmtId;
	private int publisherId;
	private String cmtusername;
	private String cmtcontent;
	private String cmtdate;
	private String reply;
	private String rpldate;
	public CommentDto() {
		super();
	}
	
	
	
	public CommentDto(int commentId, int cmtId, int publisherId, String cmtusername, String cmtcontent, String cmtdate,
			String reply, String rpldate) {
		super();
		this.commentId = commentId;
		this.cmtId = cmtId;
		this.publisherId = publisherId;
		this.cmtusername = cmtusername;
		this.cmtcontent = cmtcontent;
		this.cmtdate = cmtdate;
		this.reply = reply;
		this.rpldate = rpldate;
	}



	public int getCmtId() {
		return cmtId;
	}
	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCmtusername() {
		return cmtusername;
	}
	public void setCmtusername(String cmtusername) {
		this.cmtusername = cmtusername;
	}
	public String getCmtcontent() {
		return cmtcontent;
	}
	public void setCmtcontent(String cmtcontent) {
		this.cmtcontent = cmtcontent;
	}
	public String getCmtdate() {
		return cmtdate;
	}
	public void setCmtdate(String cmtdate) {
		this.cmtdate = cmtdate;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRpldate() {
		return rpldate;
	}
	public void setRpldate(String rpldate) {
		this.rpldate = rpldate;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}



	@Override
	public String toString() {
		return "CommentDto [commentId=" + commentId + ", cmtId=" + cmtId + ", publisherId=" + publisherId
				+ ", cmtusername=" + cmtusername + ", cmtcontent=" + cmtcontent + ", cmtdate=" + cmtdate + ", reply="
				+ reply + ", rpldate=" + rpldate + "]";
	}
	
}