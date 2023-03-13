package com.rs.fer.message.validation.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;
import com.rs.fer.message.validation.MessageValidation;
import com.rs.fer.util.FERUtil;

@Component
public class MessageValidationImpl implements MessageValidation {

	@Override
	public Set<String> validateSaveMessageRequest(SaveMessageRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMessage(), "Please enter message");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getSenderId(), "Please enter senderId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getReceiverId(), "Please enter receiverId");

		return errorMessages;

	}

	@Override
	public Set<String> validateGetMessageRequest(GetMessagesRequest request) {

		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getMessageTheradId(),
				"Please enter messageThreadId");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserdId(), "Please enter UserId");

		return errorMessages;
	}

	@Override
	public Set<String> validateDeleteMessageRequest(DeleteMessageRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter userId");
		return errorMessages;
	}

	@Override
	public Set<String> validateUpdateMessageRequest(UpdateMessageRequest request) {
		Set<String> errorMessages = new LinkedHashSet<String>();

		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getId(), "Please enter id");
		errorMessages = FERUtil.addErrorIfEmpty(errorMessages, request.getUserId(), "Please enter userId");
		return errorMessages;
	}

}
