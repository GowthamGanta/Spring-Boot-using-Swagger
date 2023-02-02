package com.rs.fer.message.validation;

import java.util.Set;

import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;

public interface MessageValidation {

	Set<String> validateSaveMessage(SaveMessageRequest request);

	Set<String> validateGetMessages(GetMessagesRequest request);
}
