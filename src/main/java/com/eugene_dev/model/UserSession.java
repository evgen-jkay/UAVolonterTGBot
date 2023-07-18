package com.eugene_dev.model;


import com.eugene_dev.enums.ConversationState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSession {
    private Long chatId;
    private ConversationState state;
    private String city;
    private String text;
}
