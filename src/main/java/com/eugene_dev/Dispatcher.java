package com.eugene_dev;

import com.eugene_dev.handler.UserRequestHandler;
import com.eugene_dev.model.UserRequest;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Dispatcher {

    private final List<UserRequestHandler> handlers;

    /**
     * Зверніть увагу на цей конструктор
     * Оскільки у нас є кілька глобальних обробників (handlers),
     * наприклад команда /start, яка може перервати будь-який потік розмови.
     * Ці глобальні обробники мають бути першими у списку
     */
    public Dispatcher(List<UserRequestHandler> handlers) {
        this.handlers = handlers
                .stream()
                .sorted(Comparator
                        .comparing(UserRequestHandler::isGlobal)
                        .reversed())
                .collect(Collectors.toList());
    }

    public boolean dispatch(UserRequest userRequest) {
        for (UserRequestHandler userRequestHandler : handlers) {
            if (userRequestHandler.isApplicable(userRequest)) {
                userRequestHandler.handle(userRequest);
                return true;
            }
        }
        return false;
    }

}
