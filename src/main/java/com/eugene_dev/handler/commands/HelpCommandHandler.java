package com.eugene_dev.handler.commands;

import com.eugene_dev.entity.User;
import com.eugene_dev.handler.UserRequestHandler;
import com.eugene_dev.helper.KeyboardHelper;
import com.eugene_dev.model.UserRequest;
import com.eugene_dev.repository.UserRepository;
import com.eugene_dev.service.TelegramService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Component
public class HelpCommandHandler extends UserRequestHandler {

    private static final String command = "/help";

    private final TelegramService telegramService;

    public HelpCommandHandler(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isCommand(userRequest.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest request) {

        telegramService.sendMessage(request.getChatId(), "\uD83D\uDC4BДовідка...");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
