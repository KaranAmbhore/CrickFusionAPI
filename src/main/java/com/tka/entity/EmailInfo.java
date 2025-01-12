package com.tka.entity;

import org.springframework.stereotype.Component;

@Component
public class EmailInfo {

	private   String subject = "One Time Password";
	private String body = " Dear User, \n \r Your One Time Password for Email Verification is : ";
	private String body2 = 
			"This OTP is valid for the next 10 minutes. Please do not share it with anyone.\r\n"
			+ "\r\n"
			+ "If you did not request this, please ignore this email.\r\n"
			+ "\r\n"
			+ "Thank you,";

	public EmailInfo() {
		// TODO Auto-generated constructor stub
	}


	
	public EmailInfo(String subject, String body, String body2) {
		super();
		this.subject = subject;
		this.body = body;
		this.body2 = body2;
	}

	
	
	
	public String getBody2() {
		return body2;
	}



	public void setBody2(String body2) {
		this.body2 = body2;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "EmailInfo [subject=" + subject + ", body=" + body + ", body2=" + body2 + "]";
	}

	
	
	
}
