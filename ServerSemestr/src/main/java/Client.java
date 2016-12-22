import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Тимур on 22.12.2016.
 */
public class Client extends Thread {
    private String userName = "Default";
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        String input, output;
        while (true) {
            try {
                input = in.readLine();
                if (input != null && !input.equals("")) {
                    System.out.println(input + " is logined!");
                    userName = input;
                    while (true) {
                            input = userName + ": " + in.readLine();

                            for (int i = 0; i < Server.sockets.size(); i++) {
                                Server.sockets.get(i).out.println(input);
                                Server.sockets.get(i).out.flush();
                            }

                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getPw() {
        return out;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public void setPw(PrintWriter pw) {
        this.out = pw;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
