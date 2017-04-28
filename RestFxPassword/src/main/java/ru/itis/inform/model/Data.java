package ru.itis.inform.model;

import javafx.beans.property.StringProperty;

/**
 * Created by alisa on 23.04.2017.
 */
public class Data {
    private StringProperty key;
    private StringProperty value;
    private User user;

    public Data(StringProperty key, StringProperty value, User user) {
        this.key = key;
        this.value = value;
        this.user = user;
    }

    public Data(StringProperty key, StringProperty value) {
        this.key = key;
        this.value = value;
    }

    public Data() {
    }

    public String getKey() {
        return key.get();
    }

    public StringProperty keyProperty() {
        return key;
    }

    public void setKey(String key) {
        this.key.set(key);
    }

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
