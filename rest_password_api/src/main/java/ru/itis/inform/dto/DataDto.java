package ru.itis.inform.dto;

/**
 * Created by timur on 10.04.17.
 */
public class DataDto {
    private String key;
    private String password;

    public DataDto(String key, String password) {
        this.key = key;
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
