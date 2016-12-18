import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.locks.ReadWriteLock;

public class Sockets {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.println("GET /sum_1_2 HTTP/1.1");
        printWriter.println("HOST: localhost");
        printWriter.println("");
        printWriter.println("");
        printWriter.flush();

        String s = "";

        Scanner scanner = new Scanner(new BufferedInputStream(socket.getInputStream()));

        while (scanner.hasNextLine()) {
            s+= scanner.nextLine()+"\n";
        }
        scanner.close();
        System.out.println(s);
    }
}
