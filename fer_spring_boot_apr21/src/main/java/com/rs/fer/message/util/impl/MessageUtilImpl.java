package com.rs.fer.message.util.impl;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.util.MessageUtil;
import com.rs.fer.util.DateUtil;

@Component
public class MessageUtilImpl implements MessageUtil {

	@Override
	public Message loadSaveMessageRequest(SaveMessageRequest request, int messageThreadId) {

		Message message = new Message();

		message.setMessage(request.getMessage());
		message.setDate(DateUtil.getCurrentDate());
		message.setSenderId(request.getSenderId());
		message.setMessageThreadId(messageThreadId);
		message.setReadFlag("N");

		return message;
	}

	@Override
	public MessageThread loadSaveMessageThreadRequest(SaveMessageRequest request, int senderId, int receiverId) {

		MessageThread messageThread = new MessageThread();

		messageThread.setSenderId(request.getSenderId());
		messageThread.setReceiverId(request.getReceiverId());
		messageThread.setEmail(request.getEmail());
		messageThread.setMobile(request.getMobile());

		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));

		messageThread.setOtp(otp);

		// String verificationCode = "" + random.nextInt (9000) + 1000 ;
		String uuid = UUID.randomUUID().toString();

		messageThread.setVerificationCode(uuid);

		messageThread.setEmailVerify("N");
		messageThread.setMobileVerify("N");

		return messageThread;
	}

}
