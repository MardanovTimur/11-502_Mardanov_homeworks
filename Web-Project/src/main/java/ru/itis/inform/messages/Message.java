package ru.itis.inform.messages;

/**
 * Created by Тимур on 06.10.2016.
 */
public class Message {
    // Класс для вывода всевозможных смс
    private static String message;
    private static String name;

    public Message(String name, String message) {
        this.message = message;
        this.name = name;
    }

    public static String getMessage() {
        return message;
    }

    public static String getName() {
        return name;
    }
}
