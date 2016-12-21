import com.esotericsoftware.kryonet.Connection;

public class User {
    private String name;
    private String password;
    private Connection connection;

    public User(String name, String password, Connection connection) {
        this.name = name;
        this.password = password;
        this.connection = connection;
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

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {

        this.connection = connection;
    }
}
