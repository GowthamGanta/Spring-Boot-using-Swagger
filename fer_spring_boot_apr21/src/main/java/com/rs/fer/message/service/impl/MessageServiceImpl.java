package com.rs.fer.message.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.message.repository.MessageRepository;
import com.rs.fer.message.repository.MessageThreadRepository;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.GetMessagesRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;
import com.rs.fer.message.response.GetMessagesResponse;
import com.rs.fer.message.response.SaveMessageResponse;
import com.rs.fer.message.response.UpdateMessageResponse;
import com.rs.fer.message.service.MessageService;
import com.rs.fer.message.util.MessageUtil;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageUtil messageUtil;

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	MessageThreadRepository messageThreadRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public SaveMessageResponse sendMessage(SaveMessageRequest request) {

		SaveMessageResponse response = null;
		Message message = null;
		MessageThread messageThread = null;

		Optional<User> userObj = userRepository.findById(request.getSenderId());

		if (!userObj.isPresent()) {

			return new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "201", "Sender is not found", null);
		}

		if (userObj.isPresent()) {
			User sender = userObj.get();

			if ("N".equalsIgnoreCase(sender.getEmailVerify())) {

				return new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "202",
						"User is already registered with the given email", null);
			}
			if ("N".equalsIgnoreCase(sender.getMobileVerify())) {

				return new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "203", "Enter otp", null);
			}

		}

		Optional<User> userObject = userRepository.findById(request.getReceiverId());
		if (!userObject.isPresent() || request.getReceiverId() <= 0) {

			return new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "204", "Receiver is not found", null);
		}
		if (userObject.isPresent()) {

			User receiver = userObj.get();

			if ("N".equalsIgnoreCase(receiver.getEmailVerify()) || "Not".equalsIgnoreCase(receiver.getEmailVerify())) {

				return new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "205",
						"User is already registered with the given email", null);
			}
			if ("N".equalsIgnoreCase(receiver.getMobileVerify()) || "Not".equalsIgnoreCase(receiver.getMobileVerify())) {

				return new SaveMessageResponse(HttpStatus.PRECONDITION_FAILED, "206", "Enter otp", null);
			}

		}

		// To get the message thread based on sender and receiver match
		List<MessageThread> messageThreadObjects = messageThreadRepository
				.findBySenderIdAndReceiverId(request.getSenderId(), request.getReceiverId());

		// To get the message thread based on receiver and sender match
		if (messageThreadObjects == null || messageThreadObjects.isEmpty()) {
			messageThreadObjects = messageThreadRepository.findBySenderIdAndReceiverId(request.getReceiverId(),
					request.getSenderId());
		}

		// If Message Thread is not found
		if (messageThreadObjects == null || messageThreadObjects.isEmpty()) {

			// load vo data into messageThread entity1
			messageThread = messageUtil.loadSaveMessageThreadRequest(request, request.getSenderId(),
					request.getReceiverId());

			// save message thread
			messageThread = messageThreadRepository.save(messageThread);
		} else {
			messageThread = messageThreadObjects.get(0);
		}

		// load VO data into message entity
		message = messageUtil.loadSaveMessageRequest(request, messageThread.getMessageThreadId());

		// save message
		message = messageRepository.save(message);

		// response if success
		if (message.getId() > 0) {
			response = new SaveMessageResponse(HttpStatus.OK, "000", "Message sent successfully", null);

			response.setMessages(message);

		} else {
			// response if failure
			response = new SaveMessageResponse(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Message send is failed", null);

		}

		return response;
	}

	@Override
	public GetMessagesResponse getMessages(GetMessagesRequest request) {

		GetMessagesResponse response = null;

		List<Message> messageThreadObjects = messageRepository.findByMessageThreadId(request.getMessageTheradId());

		if (messageThreadObjects.isEmpty()) {

			response = new GetMessagesResponse(HttpStatus.OK, "001", "No Messages found", null);

		} else {

			response = new GetMessagesResponse(HttpStatus.OK, "000", "fetch Messages", null);
			response.setMessages(messageThreadObjects.get(request.getMessageTheradId()));

		}

		return response;
	}

	@Override
	public DeleteMessageResponse deleteMessage(DeleteMessageRequest request) {
		DeleteMessageResponse response = null;

		Optional<Message> message = messageRepository.findById(request.getId());
		if (!message.isPresent()) {
			return new DeleteMessageResponse(HttpStatus.PRECONDITION_FAILED, "201", "message is not found", null);
		}

		Message sender = message.get();

		if (sender.getSenderId() != request.getUserId()) {
			return new DeleteMessageResponse(HttpStatus.PRECONDITION_FAILED, "202", "Id's not Matching", null);
		} else {
			int delete = request.getId();
			messageRepository.deleteById(delete);
			// response if success
			response = new DeleteMessageResponse(HttpStatus.OK, "000", "Message deleted successfully", null);
		}

		return response;
	}

	@Override
	public UpdateMessageResponse updateMessage(UpdateMessageRequest request) {
		Message updateMessage = new Message();
		UpdateMessageResponse response = null;
		Optional<Message> messageOptional = messageRepository.findById(request.getId());

		if (!messageOptional.isPresent()) {
			return new UpdateMessageResponse(HttpStatus.PRECONDITION_FAILED, "201", "message is not present", null);
		}

		Message message = messageOptional.get();

		Optional<MessageThread> messageThreadObj = messageThreadRepository.findById(message.getMessageThreadId());

		if (!messageThreadObj.isPresent()) {
			return new UpdateMessageResponse(HttpStatus.PRECONDITION_FAILED, "202", "Thread is not present", null);
		}

		MessageThread threadObj = messageThreadObj.get();

		if (threadObj.getReceiverId() == request.getUserId()) {
			updateMessage.setReadFlag("Y");
			messageRepository.save(updateMessage);
			response = new UpdateMessageResponse(HttpStatus.OK, "000", "Message Updated successfully", null);
		} else {
			// response if failure
			response = new UpdateMessageResponse(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Message Update is failed",
					null);
		}
		return response;

	}
}
