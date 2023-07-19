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
public class StartCommandHandler extends UserRequestHandler {

    private static final String command = "/start";

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;

    private final UserRepository userRepository;

    public StartCommandHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserRepository userRepository) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userRepository = userRepository;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isCommand(userRequest.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest request) {
        // це тустую. робе. поки зберігаємо тільки ІД чата користувача

        try {
            Long user = request.getChatId();

            User userId = userRepository.findByUserId(user);
            if (userId == null) {
                userId = new User();
                userId.setUserId(user);
            }

            userRepository.save(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // кінець

        ReplyKeyboard replyKeyboard = keyboardHelper.buildMainMenu();

        telegramService.sendMessage(request.getChatId(),
                "\uD83D\uDC4BПривіт! За допомогою цього чат-бота ви зможете зробити запит про допомогу!",
                replyKeyboard);

        telegramService.sendMessage(request.getChatId(), "Обирайте з меню нижче ⤵️");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
