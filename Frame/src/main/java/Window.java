import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

/**
 * Created by Тимур on 11.11.2016.
 */
public class Window {
    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame("test");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());


        JMenuItem topMenu = new JMenuItem();
        topMenu.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton exit = new JButton("exit");
        topMenu.add(exit);
        JButton about = new JButton("about");
        topMenu.add(about);

        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right,BoxLayout.Y_AXIS));
        JButton showRed = new JButton("Show red");
        right.add(showRed);
        JButton showTime = new JButton("Show time");
        right.add(showTime);
        JButton showWeather = new JButton("Show weather");
        right.add(showWeather);

        jFrame.getContentPane().add(topMenu);

        jFrame.setBounds(100, 100, 500, 500);

        jFrame.setVisible(true);
    }
}