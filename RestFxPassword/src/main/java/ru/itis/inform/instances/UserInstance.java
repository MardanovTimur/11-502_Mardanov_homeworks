package ru.itis.inform.instances;

import ru.itis.inform.model.ServerModel.User;

/**
 * Created by Timur Mardanov on 24.05.2017.
 * ITIS
 */
public class UserInstance {
    public static UserInstance userInstance;
    private User user;

    public UserInstance(User user) {
        userInstance = this;
        this.user = user;
    }

    public UserInstance getUserInstance() {
        return userInstance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
