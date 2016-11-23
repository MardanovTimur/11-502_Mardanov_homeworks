import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Тимур on 16.11.2016.
 */
public class
Weather implements Runnable {
    JFrame jFrame = null;
    JTextArea jTextArea = null;
    @Override
    public void run() {
        jFrame = new JFrame("Weather");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        jFrame.setLayout(borderLayout);
        JLabel jLabel = new JLabel("City:");
        jTextArea = new JTextArea("");


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JButton buttonOk = new JButton("Ok!");
        constraints.gridy = 1;
        constraints.gridwidth = 20;
        constraints.gridheight = 10;
        constraints.weighty = 1;
        jPanel.add(buttonOk, constraints);
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actionperformedOK(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        jFrame.add(jLabel, BorderLayout.WEST);
        jFrame.add(jTextArea,BorderLayout.CENTER);
        jFrame.add(jPanel, BorderLayout.EAST);

        jFrame.pack();
        jFrame.setBounds(200, 200, 300, 150);
        jFrame.setVisible(true);
    }

    public void actionperformedOK(ActionEvent e) throws Exception {
        String city = jTextArea.getText();
        String weather = sendGet(city);
        jTextArea.setText(city+" "+weather);
    }

    private final String USER_AGENT = "Mozilla/5.0";

    private String sendGet(String city) throws Exception {

        String url = "https://yandex.ru/pogoda/"+city.toLowerCase();

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        //System.out.println(response.toString());
        String[] req = response.toString().split("<div class=\"current-weather__thermometer current-weather__thermometer_type_now\">");
        String[] value = req[1].split(" ");
        return value[0];
    }
}
