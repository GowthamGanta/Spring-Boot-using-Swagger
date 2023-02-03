package com.rs.fer.message.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class MessageThread {

	@Id
	@Column(name = "messageThread_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageThreadId;

	@Column
	private int senderId;

	@Column
	private int receiverId;

	@Column
	private String mobile;

	@Column
	private String email;

	@Column
	private String otp;

	@Column
	private String verificationCode;

	@Column
	private String mobileVerify;

	@Column
	private String emailVerify;

	public MessageThread() {

	}

	public MessageThread(int senderId, int receiverId, String email, String mobile) {

		this.senderId = senderId;
		this.receiverId = receiverId;
		this.email = email;
		this.mobile = mobile;
		
	}

	public int getMessageThreadId() {
		return messageThreadId;
	}

	public void setMessageThreadId(int messageThreadId) {
		this.messageThreadId = messageThreadId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	@OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "thread_id", referencedColumnName = "messageThread_id")
	private Set<Message> messages;

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getMobileVerify() {
		return mobileVerify;
	}

	public void setMobileVerify(String mobileVerify) {
		this.mobileVerify = mobileVerify;
	}

	public String getEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(String emailVerify) {
		this.emailVerify = emailVerify;
	}

}
