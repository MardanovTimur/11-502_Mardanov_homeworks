import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Тимур on 09.12.2016.
 */
public class Client {
    private static boolean active = true;
    private static Scanner scanner = new Scanner(System.in);
    public static com.esotericsoftware.kryonet.Client client;
    private static String username="";
    private static String password="";
    private static String text;
    private static boolean registerIsTrue = false;
    private static boolean loginIsTrue = false;
    private static String message = "";

    private static boolean checkLoginMessage(LoginResp resp) {
        if (resp.getMessage().equals("You aren't registered!")) {
            System.out.println(resp.getMessage());
            login();
        } else {
            System.out.println(resp.getMessage());
            loginIsTrue = true;
        }
        return false;
    }

    private static void writeMessage() {
        System.out.print(username+": ");
        message = scanner.nextLine();
        if (!message.equals("exit")) {
            SomeRequest request = new SomeRequest();
            request.text = message;
            client.sendTCP(request);
        } else {
            loginIsTrue = false;
        }
    }

    private static boolean checkRegMessage(RegistrationResp resp) {
        if (resp.getMessage().equals("Please write another username!")) {
            System.out.println(resp.getMessage());
            register();
        } else {
            System.out.println(resp.getMessage());
            registerIsTrue = true;
            login();
        }
        return false;
    }

    public static void register(){
        System.out.println("REGISTRATION\nPlease write your username and password: ");
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();
        RegistrationReq registrationReq = new RegistrationReq();
        registrationReq.name = username;
        registrationReq.password = password;
        client.sendTCP(registrationReq);
    }

    public static void login() {
        System.out.println("Login\nPlease write your username and password: ");
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();
        LoginReq req = new LoginReq();
        req.name = username;
        req.password = password;
        client.sendTCP(req);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        client = new com.esotericsoftware.kryonet.Client();
        Kryo kryo = client.getKryo();
        kryo.register(SomeRequest.class);
        kryo.register(SomeResponse.class);
        kryo.register(LoginReq.class);
        kryo.register(LoginResp.class);
        kryo.register(RegistrationReq.class);
        kryo.register(RegistrationResp.class);
        kryo.register(User.class);
        client.start();
        client.connect(5000, "localhost", 22222, 22223);
        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof RegistrationResp) {
                    RegistrationResp resp = (RegistrationResp) object;
                    checkRegMessage(resp);
                } else {
                    if (object instanceof LoginResp) {
                        LoginResp loginResp = (LoginResp)object;
                        checkLoginMessage(loginResp);
                    }else if (object instanceof SomeResponse) {
                        SomeResponse someResponse = (SomeResponse) object;
                        System.out.println(someResponse.getText());
                    }
                }
            }

        });

        System.out.println("Welcome to chat!!!\n" +
                "Have you registered there?\n" +
                "If \"yes\" then write -Y-. Or -N- \"not\" of course!\n" +
                "If you just want to login you must write -Y-");
        text = scanner.nextLine();
        if (text.equals("N")) {
            register();
        } else {
            login();
        }
        while (active) {
            if (loginIsTrue) {
                writeMessage();
            } else {
                login();
            }
        }
    }
}
