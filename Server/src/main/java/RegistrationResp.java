/**
 * Created by Тимур on 21.12.2016.
 */
public class RegistrationResp {
    public String name;
    public String password;
    public String message;


    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
