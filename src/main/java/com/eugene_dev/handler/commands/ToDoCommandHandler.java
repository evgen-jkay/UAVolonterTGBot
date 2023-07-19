package com.eugene_dev.handler.commands;

import com.eugene_dev.handler.UserRequestHandler;
import com.eugene_dev.model.UserRequest;
import com.eugene_dev.service.TelegramService;
import org.springframework.stereotype.Component;

@Component
public class ToDoCommandHandler extends UserRequestHandler {

    private static final String command = "/todo";

    private final TelegramService telegramService;

    public ToDoCommandHandler(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isCommand(userRequest.getUpdate(), command);
    }

    @Override
    public void handle(UserRequest request) {

        telegramService.sendMessage(request.getChatId(), "v1.1 - Реалізовані кнопки, відповіді.");
        telegramService.sendMessage(request.getChatId(), "v1.2 - Реалізовано відображення повідомлень користувачів в консолі.");
        telegramService.sendMessage(request.getChatId(), "v1.3 - Реалізовано добавелнно підключення до бази даних.");
        telegramService.sendMessage(request.getChatId(), "v1.4 - Зберігаємо чат ід користувачів в базу данних");
        telegramService.sendMessage(request.getChatId(), "<strong>TODO</strong> v1.5 - Налаштуванни роботу та зберігання данних в БД... ");
    }

    @Override
    public boolean isGlobal() {
        return true;
    }

}
