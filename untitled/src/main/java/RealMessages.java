import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Тимур on 22.12.2016.
 */
public class RealMessages extends Thread {
    public static String message;
    public static Scanner scanner;

    public RealMessages() throws IOException {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(RealClient.fromserver.getInputStream())));
    }

    @Override
    public void run() {
        while (true) {
                try {
                    while (scanner.hasNextLine()) {
                        String s = scanner.nextLine();

                        MainGUI.chatBox.append(s.substring(s.indexOf(' ')+1)+"\n");
                        //System.out.println(scanner.nextLine());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
