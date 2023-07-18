package com.eugene_dev.handler.impl;

import com.eugene_dev.enums.ConversationState;
import com.eugene_dev.handler.UserRequestHandler;
import com.eugene_dev.helper.KeyboardHelper;
import com.eugene_dev.model.UserRequest;
import com.eugene_dev.model.UserSession;
import com.eugene_dev.service.TelegramService;
import com.eugene_dev.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import static com.eugene_dev.constant.Constants.BTN_CANCEL;

@Component
public class CancelHandler extends UserRequestHandler {

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public CancelHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate(), BTN_CANCEL);
    }

    @Override
    public void handle(UserRequest userRequest) {
        ReplyKeyboard replyKeyboard = keyboardHelper.buildMainMenu();
        telegramService.sendMessage(userRequest.getChatId(),
                "Обирайте з меню нижче ⤵️", replyKeyboard);

        UserSession userSession = userRequest.getUserSession();
        userSession.setState(ConversationState.CONVERSATION_STARTED);
        userSessionService.saveSession(userSession.getChatId(), userSession);
    }

    @Override
    public boolean isGlobal() {
        return true;
    }
}