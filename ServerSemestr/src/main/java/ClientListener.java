import java.io.IOException;
import java.net.Socket;

/**
 * Created by Тимур on 22.12.2016.
 */
public class ClientListener extends Thread {
    public static Socket socket = null;

    public ClientListener() {

    }

    @Override
    public void run() {
        socket = new Socket();
        while (true) {
            try {
                while ((socket = Server.serverSocket.accept()) != null) {
                    synchronized (Server.sockets) {
                        System.out.println("Client is connected.");
                        Client client = new Client(socket);
                        Server.sockets.add(client);
                        client.start();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
