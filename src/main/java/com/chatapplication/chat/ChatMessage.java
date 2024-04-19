package com.chatapplication.chat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
	private MessageType type;
    private String content;
    private String sender;
    
    public static class Builder {
    	private MessageType type;
        private String content;
        private String sender;
        
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        
        public Builder type(MessageType type) {
            this.type= type;
            return this;
        }
        
        public Builder sender(String sender) {
            this.sender= sender;
            return this;
        }
        
        public ChatMessage build() {
            ChatMessage message = new ChatMessage();
            message.content = this.content;
            message.sender = this.sender;
            message.type=this.type;
            return message;
        }
    }

	public static ChatMessage builder() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	

}
