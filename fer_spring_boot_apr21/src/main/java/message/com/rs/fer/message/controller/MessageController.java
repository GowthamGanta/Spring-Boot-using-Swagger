package com.rs.fer.message.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;
import com.rs.fer.message.response.GetMessagesResponse;
import com.rs.fer.message.response.SaveMessageResponse;
import com.rs.fer.message.response.UpdateMessageResponse;
import com.rs.fer.message.service.MessageService;
import com.rs.fer.message.validation.MessageValidation;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageValidation messageValidation;

	@Autowired
	MessageService messageService;

	@PostMapping("/sendMessage")
	public SaveMessageResponse sendMessage(@RequestBody SaveMessageRequest request) {

		SaveMessageResponse response = null;
		Set<String> errorMessages = messageValidation.validateSaveMessageRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = messageService.sendMessage(request);
		}

		return response;
	}

	@PostMapping("/getMessages")
	public GetMessagesResponse getMessages(@RequestBody GetMessagesRequest request) {

		GetMessagesResponse response = null;
		Set<String> errorMessages = messageValidation.validateGetMessageRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetMessagesResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = messageService.getMessages(request);
		}

		return response;
	}

	@DeleteMapping("/deleteMessage")
	public DeleteMessageResponse deleteMessages(@RequestBody DeleteMessageRequest request) {

		DeleteMessageResponse response = null;
		Set<String> errorMessages = messageValidation.validateDeleteMessageRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteMessageResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = messageService.deleteMessage(request);
		}

		return response;
	}

	@PutMapping("/updateMessage")
	public UpdateMessageResponse updateMessage(@RequestBody UpdateMessageRequest request) {

		UpdateMessageResponse response = null;
		Set<String> errorMessages = messageValidation.validateUpdateMessageRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdateMessageResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = messageService.updateMessage(request);
		}

		return response;
	}
}
