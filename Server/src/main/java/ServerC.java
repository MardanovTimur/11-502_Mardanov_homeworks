/**
 * Created by Тимур on 09.12.2016.
 */

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.*;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.*;

public class ServerC {

    private static String registered = " - is registered! Welcome!";
    static com.esotericsoftware.kryonet.Server server;
    static LinkedList<User> connectionsList = new LinkedList<User>();
    static LinkedList<User> logined = new LinkedList<User>();

    public static void getMessage(SomeRequest someRequest, Connection connection) {
        if (!someRequest.getText().equals("")) {
            sendMessage(someRequest.getName(), someRequest.getText());
        } else {
            System.out.println("Empty message");
        }
    }

    private static void sendMessage(String username, String text) {
        for (User user :
                logined) {
            SomeResponse someResponse = new SomeResponse();
            someResponse.text = username + ": " + text;
            user.getConnection().sendTCP(someResponse);
        }
    }

    public static void registr(RegistrationReq req, Connection connection) {
        boolean isRegisteredByName = false;
        User user = new User(req.getName(), req.getPassword(), connection);
        for (User us : connectionsList) {
            if (us.getName().equals(user.getName())) {
                isRegisteredByName = true;
            }
        }
        if (!isRegisteredByName) {
            connectionsList.add(user);
            System.out.println("User is registered");
            RegistrationResp resp = new RegistrationResp();
            resp.name = req.getName();
            resp.password = req.getPassword();
            resp.message = req.getName().concat(registered);
            connection.sendTCP(resp);
        } else {
            RegistrationResp resp = new RegistrationResp();
            resp.name = req.getName();
            resp.password = req.getPassword();
            resp.message = "Please write another username!";
            connection.sendTCP(resp);
        }
    }

    public static void checkLogIn(LoginReq loginReq, Connection connection) {
        if (!login(loginReq, connection)) {
            LoginResp loginResp = new LoginResp();
            loginResp.name = loginReq.getName();
            loginResp.password = loginReq.getPassword();
            loginResp.message = "You aren't registered!";
            connection.sendTCP(loginResp);
        }
    }

    public static boolean login(LoginReq loginReq, Connection connection) {
        for (User user :
                connectionsList) {
            if (user.getName().equals(loginReq.getName()) && user.getPassword().equals(loginReq.getPassword())) {
                System.out.println("Logined" + loginReq.getName());
                LoginResp loginResp = new LoginResp();
                loginResp.name = user.getName();
                loginResp.password = user.getPassword();
                loginResp.message = "logined!";
                connection.sendTCP(loginResp);
                for (User item : logined) {
                    LoginResp loginResp1 = new LoginResp();
                    loginResp1.name = item.getName();
                    loginResp1.password = item.getPassword();
                    loginResp1.message =  user.getName() + " is logined!!!";
                    item.getConnection().sendTCP(loginResp1);
                }
                logined.add(user);
                return true;
            }
        }
        return false;
    }


    public com.esotericsoftware.kryonet.Server getServer() {
        return server;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        server = new com.esotericsoftware.kryonet.Server();
        Kryo kryo = server.getKryo();
        kryo.register(SomeRequest.class);
        kryo.register(SomeResponse.class);
        kryo.register(LoginReq.class);
        kryo.register(LoginResp.class);
        kryo.register(RegistrationReq.class);
        kryo.register(RegistrationResp.class);
        kryo.register(User.class);
        server.start();
        server.bind(22222, 22223);
        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof RegistrationReq) {
                    RegistrationReq req = (RegistrationReq) object;
                    System.out.println("r");
                    registr(req, connection);
                } else {
                    if (object instanceof LoginReq) {
                        LoginReq loginReq = (LoginReq) object;
                        System.out.println("l");
                        checkLogIn(loginReq, connection);
                    } else if (object instanceof SomeRequest) {
                        SomeRequest someRequest = (SomeRequest) object;
                        System.out.println("m");
                        getMessage(someRequest, connection);
                    }
                }
            }
        });
    }

}

