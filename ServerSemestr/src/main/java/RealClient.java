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


    public static void main(String[] argc) throws InterruptedException {

        try {
            fromserver = new Socket("localhost", 1234);
            printWriter = new PrintWriter(fromserver.getOutputStream());
            RealMessages realMessages = new RealMessages();
            realMessages.start();
            System.out.println("This is chat. Hellooo!\n");
            Thread.sleep(1000);
            System.out.println("What is your name and password?\n");
            Thread.sleep(1000);
            System.out.println("Else matters) cause this chat only support login ^)\n" +
                    "ddos atacks allows\n" +
                    "fun!\n" +
                    "write /exit to leave this chat");
            System.out.println("Write your username!");
            sc = new Scanner(System.in);
            printWriter.println(sc.nextLine());
            printWriter.flush();
            while (true) {
                String message = sc.nextLine();
                if (message.equals("/exit")) {
                    printWriter.println(message);
                    printWriter.flush();
                    break;
                } else {
                    printWriter.println(message);
                    printWriter.flush();
                }
            }
            System.out.println("!BYE!");
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
