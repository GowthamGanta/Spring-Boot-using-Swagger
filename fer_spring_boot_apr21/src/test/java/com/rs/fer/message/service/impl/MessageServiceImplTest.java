package com.rs.fer.message.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
public class MessageServiceImplTest {

	@InjectMocks
	private MessageServiceImpl messageServiceImpl;

	@Mock
	MessageService messageService;

	@Mock
	MessageRepository messageRepository;

	@Mock
	UserRepository userRepository;

	@Mock
	MessageThreadRepository messageThreadRepository;

	@Mock
	MessageUtil messageUtil;

	@Test
	public void testSendMessage() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);

		List<MessageThread> messageThreadObjects = new ArrayList<>();

		MessageThread messageThread = new MessageThread();
		messageThread.setMessageThreadId(11);

		SaveMessageRequest request = new SaveMessageRequest();
		request.setSenderId(13);
		request.setReceiverId(22);

		Message message = new Message();
		message.setId(10);

		// Mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(messageThreadRepository.findBySenderIdAndReceiverId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThreadObjects);

		when(messageUtil.loadSaveMessageThreadRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThread);

		when(messageThreadRepository.save(Mockito.any())).thenReturn(messageThread);

		when(messageUtil.loadSaveMessageRequest(Mockito.any(), Mockito.anyInt())).thenReturn(message);

		when(messageRepository.save(Mockito.any())).thenReturn(message);

		SaveMessageResponse response = messageServiceImpl.sendMessage(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testSendMessageFailure() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);

		List<MessageThread> messageThreadObjects = new ArrayList<>();

		MessageThread messageThread = new MessageThread();
		messageThread.setMessageThreadId(11);

		SaveMessageRequest request = new SaveMessageRequest();
		request.setSenderId(13);
		request.setReceiverId(22);

		Message message = new Message();
		// message.setId(10);

		// Mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(messageThreadRepository.findBySenderIdAndReceiverId(Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThreadObjects);

		when(messageUtil.loadSaveMessageThreadRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(messageThread);

		when(messageThreadRepository.save(Mockito.any())).thenReturn(messageThread);

		when(messageUtil.loadSaveMessageRequest(Mockito.any(), Mockito.anyInt())).thenReturn(message);

		when(messageRepository.save(Mockito.any())).thenReturn(message);

		SaveMessageResponse response = messageServiceImpl.sendMessage(request);

		assertEquals("001", response.statusCode);

	}

	@Test
	public void testSenderIsNotFound() {

		Optional<User> userObj = Optional.empty();

		SaveMessageRequest request = new SaveMessageRequest();
		request.setSenderId(13);
		request.setReceiverId(22);

		// Mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveMessageResponse response = messageServiceImpl.sendMessage(request);

		assertEquals("201", response.statusCode);

	}

	@Test
	public void testSenderUserAlreadyExists() {
		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveMessageRequest request = new SaveMessageRequest();

		User sender = userObj.get();
		sender.setEmailVerify("N");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveMessageResponse response = messageServiceImpl.sendMessage(request);

		assertEquals("202", response.statusCode);

	}

	@Test
	public void testSenderMobileOTP() {
		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveMessageRequest request = new SaveMessageRequest();

		User sender = userObj.get();
		sender.setMobileVerify("N");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveMessageResponse response = messageServiceImpl.sendMessage(request);

		assertEquals("203", response.statusCode);

	}

	@Test
	public void testGetmessages() {

		Message messageThread = new Message();
		messageThread.setMessageThreadId(1);

		List<Message> messageThreadObjects = new ArrayList<>();
		messageThreadObjects.add(messageThread);

		when(messageRepository.findByMessageThreadId(Mockito.anyInt())).thenReturn(messageThreadObjects);

		GetMessagesRequest request = new GetMessagesRequest();

		request.setUserdId(1);

		GetMessagesResponse response = messageServiceImpl.getMessages(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetmessagesFailure() {

		Message messageThread = new Message();
		messageThread.setMessageThreadId(1);

		List<Message> messageThreadObjects = new ArrayList<>();
		// messageThreadObjects.add(messageThread);

		when(messageRepository.findByMessageThreadId(Mockito.anyInt())).thenReturn(messageThreadObjects);

		GetMessagesRequest request = new GetMessagesRequest();

		request.setUserdId(1);

		GetMessagesResponse response = messageServiceImpl.getMessages(request);

		assertEquals("001", response.statusCode);

	}

	@Test
	public void testDeleteMessage() {
		Message message = new Message();
		Optional<Message> messageObj = Optional.of(message);

		DeleteMessageRequest request = new DeleteMessageRequest();
		request.setId(13);
		request.setUserId(22);

		Message sender = messageObj.get();
		sender.setSenderId(22);

		when(messageRepository.findById(Mockito.anyInt())).thenReturn(messageObj);
		when(messageRepository.save(Mockito.any())).thenReturn(sender);

		DeleteMessageResponse response = messageServiceImpl.deleteMessage(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testDeleteMessageNotFound() {
		Optional<Message> messageObj = Optional.empty();

		DeleteMessageRequest request = new DeleteMessageRequest();
		request.setId(13);
		request.setUserId(22);

		when(messageRepository.findById(Mockito.anyInt())).thenReturn(messageObj);
		DeleteMessageResponse response = messageServiceImpl.deleteMessage(request);
		assertEquals("201", response.statusCode);

	}

	@Test
	public void testDeleteMessageIdsNotMatching() {
		Message message = new Message();
		Optional<Message> messageObj = Optional.of(message);

		DeleteMessageRequest request = new DeleteMessageRequest();
		request.setId(13);
		request.setUserId(22);

		Message sender = messageObj.get();
		sender.setSenderId(28);

		when(messageRepository.findById(Mockito.anyInt())).thenReturn(messageObj);
		when(messageRepository.save(Mockito.any())).thenReturn(sender);

		DeleteMessageResponse response = messageServiceImpl.deleteMessage(request);

		assertEquals("202", response.statusCode);

	}

	@Test
	public void testUpdateMessage() {
		Message messageObj = new Message();
		Optional<Message> messageOptional = Optional.of(messageObj);

		UpdateMessageRequest request = new UpdateMessageRequest();
		request.setId(13);
		request.setUserId(22);

		Message message = messageOptional.get();
		MessageThread messageThread = new MessageThread();
		Set<Message> messages = new HashSet<>();
		messages.add(message);
		messageThread.setMessages(messages);
		Optional<MessageThread> messageThreadObj = Optional.of(messageThread);

		MessageThread threadObj = messageThreadObj.get();
		threadObj.setReceiverId(22);

		messageObj.setReadFlag("Y");

		when(messageRepository.findById(Mockito.anyInt())).thenReturn(messageOptional);
		when(messageThreadRepository.findById(Mockito.anyInt())).thenReturn(messageThreadObj);

		when(messageRepository.save(Mockito.any())).thenReturn(messageObj);

		UpdateMessageResponse response = messageServiceImpl.updateMessage(request);
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testUpdateMessageFailure() {
		Message messageObj = new Message();
		Optional<Message> messageOptional = Optional.of(messageObj);

		UpdateMessageRequest request = new UpdateMessageRequest();
		// request.setId(13);
		// request.setUserId(22);

		Message message = messageOptional.get();
		MessageThread messageThread = new MessageThread();
		Set<Message> messages = new HashSet<>();
		messages.add(message);
		messageThread.setMessages(messages);
		Optional<MessageThread> messageThreadObj = Optional.of(messageThread);

		MessageThread threadObj = messageThreadObj.get();
		threadObj.setReceiverId(22);

		// messageObj.setReadFlag("Y");

		when(messageRepository.findById(Mockito.anyInt())).thenReturn(messageOptional);
		when(messageThreadRepository.findById(Mockito.anyInt())).thenReturn(messageThreadObj);

		when(messageRepository.save(Mockito.any())).thenReturn(messageObj);

		UpdateMessageResponse response = messageServiceImpl.updateMessage(request);
		assertEquals("001", response.statusCode);
	}

	@Test
	public void testUpdateMessageNotFound() {
		Optional<Message> messageOptional = Optional.empty();

		UpdateMessageRequest request = new UpdateMessageRequest();
		request.setId(13);
		request.setUserId(22);

		when(messageRepository.findById(Mockito.anyInt())).thenReturn(messageOptional);

		UpdateMessageResponse response = messageServiceImpl.updateMessage(request);
		assertEquals("201", response.statusCode);

	}

	@Test
	public void testUpdateThreadNotFound() {
		Message messageObj = new Message();
		Optional<Message> messageOptional = Optional.of(messageObj);

		UpdateMessageRequest request = new UpdateMessageRequest();
		request.setId(13);
		request.setUserId(22);

		Message message = messageOptional.get();
		MessageThread messageThread = new MessageThread();
		Set<Message> messages = new HashSet<>();
		messages.add(message);
		messageThread.setMessages(messages);
		Optional<MessageThread> messageThreadObj = Optional.empty();
		messageObj.setReadFlag("Y");

		when(messageRepository.findById(Mockito.anyInt())).thenReturn(messageOptional);
		when(messageThreadRepository.findById(Mockito.anyInt())).thenReturn(messageThreadObj);

		when(messageRepository.save(Mockito.any())).thenReturn(messageObj);

		UpdateMessageResponse response = messageServiceImpl.updateMessage(request);
		assertEquals("202", response.statusCode);

	}

}
