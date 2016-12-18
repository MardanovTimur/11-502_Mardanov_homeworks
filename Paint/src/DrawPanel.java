import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;

import static java.lang.Math.sqrt;
import static java.lang.Thread.sleep;


public class DrawPanel extends JComponent {
    private Image image;
    private Graphics2D g;
    private int currentX, currentY, oldX, oldY;

    private Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int vert = sSize.height;
    private int hor = sSize.width;


    public Graphics2D getG() {
        return g;
    }

    public DrawPanel() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                g.setColor(MainFrame.color);
                oldX = e.getX();
                oldY = e.getY();
                if (g != null) {
                    g.fillOval(oldX, oldY,MainFrame.size,MainFrame.size);
                    repaint();
                }
            }

            public void mousePressed(MouseEvent e) {

                g.setColor(MainFrame.color);
                oldX = e.getX();
                oldY = e.getY();
                if (g != null) {
                    g.fillOval(oldX, oldY,MainFrame.size,MainFrame.size);
                    repaint();
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setColor(MainFrame.color);
                currentX = e.getX();
                currentY = e.getY();

                if (g != null) {
                    g.fillOval(oldX, oldY,MainFrame.size,MainFrame.size);
                    g.fillOval(currentX,currentY,MainFrame.size,MainFrame.size);
                    //g.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });

    }
    public void paintComponent(Graphics graphics) {
        if (image == null) {

            image = createImage(hor, vert);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }

        graphics.drawImage(image, 0, 0, null);
    }
    public void addImageForAphine() {
        g.fillRect(180, 180, 120, 100);
        repaint();
    }

    public void aphine1() {
        clear();
        AffineTransform affineTransform = g.getTransform();
        affineTransform = new AffineTransform(1, 0, 1 / Math.sqrt(3), 1, 0, 0);
        g.transform(affineTransform);
        addImageForAphine();
        repaint();
    }

    public void aphine2() {
        clear();
        AffineTransform affineTransform = g.getTransform();
        affineTransform = AffineTransform.getRotateInstance(Math.PI / 4, 180, 180);
        g.transform(affineTransform);
        addImageForAphine();
        repaint();
    }

    public void resetAphine() {
        clear();
        AffineTransform affineTransform = new AffineTransform();
        g.setTransform(affineTransform);
        addImageForAphine();
        repaint();
    }

    public void animate() throws InterruptedException {
        Thread ani = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    aphine2();
                    try {
                        sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        ani.start();

    }


    public void clear() {
        g.setPaint(Color.white);
        g.fillRect(0, 0, hor, vert);
        g.setPaint(Color.black);
        repaint();
    }

    public void fill(Color color) {
        Color tmpcolor = g.getColor();
        g.setPaint(color);
        g.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
        g.setPaint(tmpcolor);
    }

    public void fill(Image image) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        repaint();

    }
}

