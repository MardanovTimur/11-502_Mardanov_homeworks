package ru.itis.inform.messages;

/**
 * Created by Тимур on 06.10.2016.
 */
public class Message {
    private static String message;
    private static String name;

    public Message(String message, String name) {
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
