package ru.itis.inform.errors;

/**
 * Created by Тимур on 06.10.2016.
 */
public class Error {
    private String name;
    private String message;

    public Error(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
