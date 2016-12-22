import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Тимур on 22.12.2016.
 */
public class RealClient {
    public static Socket fromserver;
    private static String username = "";
    public static PrintWriter printWriter;
    private static Scanner sc;


    public static void main(String[] argc) {

        try {
            fromserver = new Socket("localhost", 1234);
            printWriter = new PrintWriter(fromserver.getOutputStream());
            RealMessages realMessages = new RealMessages();
            realMessages.start();
            System.out.println("Write your username!");
            sc = new Scanner(System.in);
            printWriter.println(sc.nextLine());
            printWriter.flush();
            while (true) {
                String message = sc.nextLine();
                printWriter.println(message);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
