import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.sqrt;

/**
 * Created by Тимур on 17.11.2016.
 */
public class MainFrame extends JFrame implements Runnable {
    //variables
    static int oldX = 0;
    static int oldY = 0;
    static int size = 4;

    static DrawPanel paintPanel;
    static JFrame jFrame;
    private ColorChoose colorChoose = new ColorChoose();
    static Color color = Color.black;

    @Override
    public void run() {
        jFrame = new JFrame("Paint");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());

        paintPanel = new DrawPanel();
        paintPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        paintPanel.setSize(500, 400);



        jFrame.add(paintPanel, BorderLayout.CENTER);

        JPanel editorPanel = new JPanel();
        editorPanel.setLayout(new GridBagLayout());
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        editorPanel.setBorder(etchedBorder);
        editorPanel.setPreferredSize(new Dimension(500, 100));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JButton openChooser = new JButton("Open chooser");
        openChooser.setSize(20, 10);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        openChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(colorChoose);
                thread.start();
                if (thread.isAlive()) {
                    try {
                        thread.join();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        editorPanel.add(openChooser, gridBagConstraints);
        JSlider jSlider = new JSlider(1,40,5);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                size = jSlider.getValue();
                paintPanel.getG().setStroke(new BasicStroke(size));
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        editorPanel.add(jSlider,gridBagConstraints);
        gridBagConstraints.ipadx = 0;
        JButton clear = new JButton("Clear");
        JButton fill = new JButton("Fill");

        gridBagConstraints.gridx = 2;
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.clear();
            }
        });
        editorPanel.add(clear,gridBagConstraints);

        gridBagConstraints.gridx = 3;
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.fill(color);
            }
        });
        editorPanel.add(fill,gridBagConstraints);

        JButton imageButton = new JButton("Image");
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser jFileChooser = new JFileChooser();
                    int returnVal = jFileChooser.showDialog(null,"Выбрать файл");
                    if (returnVal==JFileChooser.APPROVE_OPTION){
                        File myPicture = jFileChooser.getSelectedFile();
                        BufferedImage bufferedImage= ImageIO.read(myPicture);
                        Image resizingImage = bufferedImage;
                        paintPanel.fill(resizingImage);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        gridBagConstraints.gridx=4;
        editorPanel.add(imageButton,gridBagConstraints);

        JButton translateAffine = new JButton("Affine translate 45.");
        translateAffine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                paintPanel.affine();
            }
        });
        gridBagConstraints.gridx = 5;
        editorPanel.add(translateAffine,gridBagConstraints);


        jFrame.add(editorPanel, BorderLayout.PAGE_END);
        jFrame.setBounds(100, 100, 600, 600);
        jFrame.setVisible(true);
    }

    private void jPanel2MousePressed(MouseEvent evt) {
        oldX = evt.getX();
        oldY = evt.getY();
    }
}

