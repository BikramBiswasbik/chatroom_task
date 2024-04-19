package com.chatapplication.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatapplication.chat.ChatMessage;
import com.chatapplication.chat.Message;
import com.chatapplication.chat.Message1;
import com.chatapplication.service.MessageService;

@RestController
@RequestMapping("/chatroom")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
    	return message;
//        return messageService.saveMessage(message);
    }
    
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
    	 // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
    
    @GetMapping("/")
    public List<Message> getAllMessages(@RequestParam String username) {
        return messageService.getAllMessagesForUser(username);
    }
    
    
    @MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message1 getContent(@RequestBody Message1 msg) {
        return msg;
    }
    
}