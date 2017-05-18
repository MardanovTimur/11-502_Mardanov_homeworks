package ru.itis.inform.model.ServerModel;

/**
 * Created by Timur Mardanov on 12.05.2017.
 * ITIS
 */
public class Message {
    private String key;
    private String value;

    public Message(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
