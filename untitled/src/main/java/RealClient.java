import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Тимур on 22.12.2016.
 */
public class RealClient extends Thread {
    public static Socket fromserver;
    public static String username = "";
    public static PrintWriter printWriter;
    private static Scanner sc;
    static boolean f = false;

    @Override
    public void run() {
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
            while (username.equals("")) {
                synchronized (MainGUI.username) {

                }
            }
            printWriter.println(MainGUI.username);
            printWriter.flush();
            String test = "";
            while (true) {
                synchronized (MainGUI.text) {
                    while (test.equals(MainGUI.text)) {
                        synchronized (MainGUI.text) {
                        }
                    }
                }
                String message = MainGUI.text;
                test = MainGUI.text;
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
