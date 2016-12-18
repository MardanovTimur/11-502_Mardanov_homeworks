import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Тимур on 02.12.2016.
 */
public class Server {
    public static ArrayList<ClientConnection> connections = new ArrayList<ClientConnection>();


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket;
        while (true) {
            try {
                while ((socket = serverSocket.accept()) != null) {
                    ClientConnection clientConnection = new ClientConnection(socket);
                    connections.add(clientConnection);
                    new Thread(clientConnection).start();
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
}

class ClientConnection implements Runnable {
    private static final String MESSAGE = "Hello world!";

    Socket socket;

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            Integer a = -1;
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String s = br.readLine();
                if (s == null || s.trim().length() == 0) {
                    break;
                }
                if (calc(s) != -1) {
                    a = calc(s);
                }
                System.out.println(s);
            }
            System.out.println("---");
            // Create and send response
            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println("HTTP/1.1 200 OK");
            pr.println("Content-type:text/plain;Charset:UTF-8");
            pr.println("Content-length: just number");
            pr.println();
            pr.println(a);
            pr.flush();
            socket.close();
        } catch (Exception e) {
            System.out.println("This is exception!");
        }
    }

    public int calc(String s) {
        String[] a = s.split(" ");
        if (a[0].equals("GET")) {
            String[] b = a[1].split("_");
            if (b.length==1) {
                if (a[1].equals("/clients")) {
                    return Server.connections.size();
                }
            } else {
                int first = Integer.parseInt(b[1]);
                int second = Integer.parseInt(b[2]);
                switch (b[0]) {
                    case "/sum":
                        return first + second;
                    case "/min":
                        return first - second;
                    case "/div":
                        return first / second;
                    case "/mult":
                        return first * second;
                }
            }
        }
        return -1;
    }
}
