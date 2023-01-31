package com.rs.fer.message.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.response.SaveMessageResponse;
import com.rs.fer.message.service.MessageService;
import com.rs.fer.message.validation.MessageValidation;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	MessageValidation messageValidation;

	@Autowired
	MessageService messageService;

	@PostMapping("/saveMessage")
	public SaveMessageResponse saveMessage(@RequestBody SaveMessageRequest request) {

		SaveMessageResponse response = null;
		Set<String> errorMessages = messageValidation.validateSaveMessage(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = messageService.saveMessage(request);
		}
		return response;

	}
}
