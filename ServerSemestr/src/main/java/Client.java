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
        boolean f = true;
        String input = "", output;
        while (input == null || input.equals("")) {
            if (!socket.isConnected()) {
                this.interrupt();
                f = false;
                Server.sockets.remove(this);
                this.interrupt();
            } else {
                try {
                    input = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        userName = input;
        System.out.println(input + " is logined!");
        while (f) {
            try {
                input = userName + ": " + in.readLine();
                //exit
                if (input.split(": ")[1].equals("/exit")) {
                    Server.sockets.remove(this);
                    socket.close();
                    this.interrupt();
                    break;
                } else {
                    for (int i = 0; i < Server.sockets.size(); i++) {
                        if (!Server.sockets.get(i).getUserName().equals(userName)) {
                            Server.sockets.get(i).out.println(input);
                            Server.sockets.get(i).out.flush();
                        }
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
                break;
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
