import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Тимур on 15.11.2016.
 */
public class AboutFrame implements Runnable{
    JFrame jFrame = null;
    @Override
    public void run(){
        jFrame = new JFrame("About");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        jFrame.setLayout(borderLayout);
        JLabel jLabel = new JLabel("Information!!!");

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JLabel picture = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\Frame\\src\\main\\resources\\infoloko.png"));
            Image resizingImage = myPicture.getScaledInstance(40,40,Image.SCALE_DEFAULT);
            picture = new JLabel(new ImageIcon(resizingImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1;
        jPanel.add(picture,constraints);

        JButton buttonOk = new JButton("Ok!");
        constraints.gridy = 1;
        constraints.gridwidth=20;
        constraints.gridheight = 10;
        constraints.weighty = 1;
        jPanel.add(buttonOk,constraints);
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionperformedOK(e);
            }
        });

        jFrame.add(jLabel,BorderLayout.WEST);
        jFrame.add(jPanel,BorderLayout.EAST);

        jFrame.pack();
        jFrame.setBounds(200, 200, 300, 150);
        jFrame.setVisible(true);
    }

    public void actionperformedOK(ActionEvent e){
        jFrame.dispose();
    }

}
