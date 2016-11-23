import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.*;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Window {
    static JButton showRed;
    static JFrame jFrame;
    static JPanel left;
    static int count = 0;
    static int countTime = 0;
    static JLabel jLabel;
    static JButton showTime;

    public static void main(String[] args) throws InterruptedException {

        jFrame = new JFrame("test");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());

        JMenuBar jMenuBar = new JMenuBar();

        JMenu exit = new JMenu("Exit");
        exit.setMnemonic('e');
        exit.addMenuListener(new MenuListenerExit());

        JMenu about = new JMenu("About");
        about.setMnemonic('a');
        about.addMenuListener(new MenuListenerAbout());

        jMenuBar.add(exit);
        jMenuBar.add(about);

        jLabel = new JLabel();
        jLabel.setText("                                                    ");
        left = new JPanel();
        left.setSize(400, 500);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.ipady = 500;
        constraints.ipadx = 500;
        left.setBackground(Color.cyan);
        left.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black));
        left.add(jLabel);
        jFrame.add(left, BorderLayout.CENTER);

        JPanel right = new JPanel();
        right.setLayout(new GridBagLayout());
        GridBagConstraints constraintsButtons = new GridBagConstraints();

        showRed = new JButton("Show red");
        showRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListenerShowRed(e);
            }
        });
        constraintsButtons.fill = GridBagConstraints.HORIZONTAL;
        constraintsButtons.gridx = 0;
        constraintsButtons.gridy = 0;
        constraintsButtons.weighty = 3;
        constraintsButtons.insets = new Insets(10, 2, 0, 0);
        right.add(showRed, constraintsButtons);

        showTime = new JButton("Show time");
        showTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListenerShowTime(e);
            }
        });
        constraintsButtons.gridx = 0;
        constraintsButtons.gridy = 1;
        right.add(showTime, constraintsButtons);
        JButton showWeather = new JButton("Show weather");
        constraintsButtons.gridx = 0;
        constraintsButtons.gridy = 2;
        showWeather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Weather weather = new Weather();
                Thread thread = new Thread(weather);
                thread.start();
            }
        });
        right.add(showWeather, constraintsButtons);


        jFrame.add(right, BorderLayout.EAST);
        jFrame.setMaximumSize(new Dimension(500, 500));
        jFrame.setResizable(true);
        jFrame.pack();
        jFrame.setBounds(100, 100, 500, 500);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setVisible(true);
    }

    static class MenuListenerExit implements MenuListener {
        public void menuSelected(MenuEvent e) {
            menuDeselected(e);
        }

        public void menuDeselected(MenuEvent e) {
            System.exit(0);
        }

        public void menuCanceled(MenuEvent e) {

        }
    }

    public static void ActionListenerShowRed(ActionEvent e) {
        if (count % 2 == 0) {
            left.setBackground(Color.RED);
            showRed.setText("Show Cyan!");
        } else {
            left.setBackground(Color.cyan);
            showRed.setText("Show Red!");
        }
        count++;
    }

    public static void ActionListenerShowTime(ActionEvent e) {
        Date date = new Date();
        if (countTime % 2 == 0) {
            jLabel.setText(date.toString());
            showTime.setText("Hide Time!");
        } else {
            jLabel.setText("                                                   ");
            showTime.setText("Show Time!");
        }
        countTime++;
    }


    static class MenuListenerAbout implements MenuListener {
        AboutFrame aboutFrame;

        public void menuSelected(MenuEvent e) {
            aboutFrame = new AboutFrame();
            Thread aboutJFRAME = new Thread(aboutFrame);
            aboutJFRAME.start();
        }

        public void menuDeselected(MenuEvent e) {

        }

        public void menuCanceled(MenuEvent e) {

        }
    }
}
