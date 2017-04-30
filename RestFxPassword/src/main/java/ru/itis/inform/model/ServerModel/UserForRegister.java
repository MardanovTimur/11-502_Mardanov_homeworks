package ru.itis.inform.model.ServerModel;

public class UserForRegister {
    private String name;
    private String username;
    private String password;
    private String password_again;

    public UserForRegister(String name, String username, String password, String password_again) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.password_again = password_again;
    }

    public UserForRegister() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_again() {
        return password_again;
    }

    public void setPassword_again(String password_again) {
        this.password_again = password_again;
    }
}
