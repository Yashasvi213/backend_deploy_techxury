package com.dev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class emailOTP {
	@Id
	@GeneratedValue
	int eid;
	String email;
	String subject;
	String body;
	int otp;
	public emailOTP(String email, String subject, String body, int oTP) {
		super();
		this.email = email;
		this.subject = subject;
		this.body = body;
		otp = oTP;
	}
	public emailOTP() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "emailOTP [email=" + email + ", subject=" + subject + ", body=" + body + ", OTP=" + otp + "]";
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
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
	public int getOTP() {
		return otp;
	}
	public void setOTP(int oTP) {
		otp = oTP;
	}
}
