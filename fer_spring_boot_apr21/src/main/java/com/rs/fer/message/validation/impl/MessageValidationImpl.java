package com.rs.fer.message.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.validation.MessageValidation;
import com.rs.fer.util.FERUtil;

@Component
public class MessageValidationImpl implements MessageValidation {

	@Override
	public Set<String> validateSaveMessage(SaveMessageRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMessage(), "Please enter message");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getSenderId(), "Please enter senderId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getReceiverId(), "Please enter receiverId");

		return errorMessages;
	}

}
