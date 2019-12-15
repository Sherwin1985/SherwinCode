package com.coding.challenge.project.bean;

import java.util.Date;

public class MessageBean {

	private String message;
	
	private Date messageTime;

	public MessageBean() {
		
	}
	
	public MessageBean(String message, Date messageTime) {
		this.message = message;
		this.messageTime = messageTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	
	
}
