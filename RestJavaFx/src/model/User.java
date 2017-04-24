package model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * Created by alisa on 23.04.2017.
 */
public class User {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty username;
    private StringProperty password;
    private ListProperty<Data> data;

    public User(IntegerProperty id, StringProperty name, StringProperty username, StringProperty password, ListProperty<Data> data) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.data = data;
    }

    public User() {
    }

    public User(IntegerProperty id, StringProperty name, StringProperty username, StringProperty password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public ObservableList<Data> getData() {
        return data.get();
    }

    public ListProperty<Data> dataProperty() {
        return data;
    }

    public void setData(ObservableList<Data> data) {
        this.data.set(data);
    }
}
