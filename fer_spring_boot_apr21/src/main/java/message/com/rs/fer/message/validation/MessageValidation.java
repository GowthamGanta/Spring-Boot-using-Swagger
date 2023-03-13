package com.rs.fer.message.validation;

import java.util.Set;

import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;

public interface MessageValidation {

	Set<String> validateSaveMessageRequest(SaveMessageRequest request);

	Set<String> validateGetMessageRequest(GetMessagesRequest request);

	Set<String> validateDeleteMessageRequest(DeleteMessageRequest request);

	Set<String> validateUpdateMessageRequest(UpdateMessageRequest request);
}
