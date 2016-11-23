/**
 * Created by Тимур on 17.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Thread main = new Thread(mainFrame);
        main.start();
    }
}
