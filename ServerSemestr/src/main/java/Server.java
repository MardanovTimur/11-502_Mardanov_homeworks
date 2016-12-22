import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by Тимур on 22.12.2016.
 */
public class Server extends Thread {
    public static ServerSocket serverSocket;
    public static LinkedList<Client> sockets;
    private static BufferedReader in = null;
    private static PrintWriter out = null;

    public Server() {
        try {
            this.serverSocket = new ServerSocket(1234);
            System.out.println("Server is ready!\nWaiting connections!");
        } catch (IOException e) {
            System.out.println("Port isn't available");
            System.out.println(-1);
        }
        this.sockets = new LinkedList<Client>();
    }

    @Override
    public void run() {
        System.out.println("Chat is ready!");
        while (true) {

        }
    }

    public static void main(String[] argc) {
        Server server = new Server();
        server.start();
        ClientListener clientListener = new ClientListener();
        clientListener.start();
    }
}


