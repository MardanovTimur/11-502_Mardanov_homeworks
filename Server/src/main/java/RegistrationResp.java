/**
 * Created by Тимур on 21.12.2016.
 */
public class RegistrationResp {
    private String name;
    private String password;
    private String message;

    public RegistrationResp(String name, String password, String message) {
        this.name = name;
        this.password = password;
        this.message = message;
    }

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
