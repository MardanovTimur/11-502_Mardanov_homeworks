import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Тимур on 17.11.2016.
 */
class ColorChoose implements Runnable {
    static JFrame jFrame;
    private JPanel jPanel;
    static JColorChooser colorChooser;
    private static final Color DEF_COLOR= Color.BLACK;
    static Color color = DEF_COLOR;
    @Override
    public void run() {
        jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());
        jPanel = new JPanel();
        jPanel.setSize(300,300);
        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(new changeListener());
        colorChooser.setBorder(BorderFactory.createTitledBorder(
                "Choose Text Color"));
        jPanel.add(colorChooser);
        jFrame.add(jPanel,BorderLayout.CENTER);
        JButton buttonOk = new JButton("Ok");
        buttonOk.addActionListener(new changeListenerOk());
        jFrame.add(buttonOk, BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class changeListener implements ChangeListener{
    @Override
    public void stateChanged(ChangeEvent e) {
        ColorChoose.color = ColorChoose.colorChooser.getColor();
        MainFrame.color = ColorChoose.color;

    }
}
class changeListenerOk implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.color = ColorChoose.color;
        ColorChoose.jFrame.dispose();
    }
}
