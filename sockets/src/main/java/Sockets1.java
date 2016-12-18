import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Тимур on 02.12.2016.
 */
public class Sockets1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        printWriter.println("GET /clients HTTP/1.1");
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

