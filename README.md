## UAVolunteerTGBot

### Створено за допомогою:
- Maven
- Java 11<
- Spring Boot
- Telegram Bot Library for Java(https://github.com/rubenlagus/TelegramBots)

### Функціонал бота:
- Дозволяє надсилати запити на допомогу від користувачів

### Запуск:
1. Створити бота через BotFather (`t.me/BotFather`)
2. Перейменуйте файл `application_example.yml` на `application.yml`
3. Вкажіть `token` та `username` в `application.yml`
4. Запустити `Application.main()`
5. Бот буде автоматично зареєстрований, оскільки містить
   `telegrambots-spring-boot-starter`
6. Тепер перейдіть до свого бота та спробуйте надіслати йому текст