/**
 * Created by Тимур on 17.11.2016.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

/* ColorChooserDemo.java requires no other files. */
class ColorChooserDemo extends JPanel
        implements ChangeListener {

    private JColorChooser tcc;
    private JLabel banner;
    private static Color color = null;

    private void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    private ColorChooserDemo() {
        super(new BorderLayout());

        //Set up the banner at the top of the window
        banner = new JLabel("Welcome to the Tutorial Zone!",
                JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));

        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

        //Set up color chooser for setting text color
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                "Choose Text Color"));

        add(tcc, BorderLayout.PAGE_END);
    }

    public void stateChanged(ChangeEvent e) {
        Color newColor = tcc.getColor();
        banner.setForeground(newColor);
        setColor(newColor);
        ColorChooserDemo.color = newColor;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ColorChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ColorChooserDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    static void openChooser(){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}