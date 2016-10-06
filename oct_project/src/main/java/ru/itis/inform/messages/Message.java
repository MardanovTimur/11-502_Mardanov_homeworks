package ru.itis.inform.messages;

/**
 * Created by Тимур on 06.10.2016.
 */
public class Message {
    private String message;
    private String name;

    public Message(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}
