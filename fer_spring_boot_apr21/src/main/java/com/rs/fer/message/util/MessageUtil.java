package com.rs.fer.message.util;

import com.rs.fer.message.entity.Message;
import com.rs.fer.message.entity.MessageThread;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.request.UpdateMessageRequest;

public interface MessageUtil {

	Message loadSaveMessageRequest(SaveMessageRequest request, int messageThreadId);

	MessageThread loadSaveMessageThreadRequest(SaveMessageRequest request, int senderId, int receiverId);
}

