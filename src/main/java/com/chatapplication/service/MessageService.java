package com.chatapplication.service;

import java.util.List;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapplication.chat.Message;
import com.chatapplication.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
    	message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> getAllMessagesForUser(String username) {
        return messageRepository.findBySenderOrReceiverOrderByTimestampDesc(username, username);
    }
}
