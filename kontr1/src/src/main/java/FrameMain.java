import jdk.nashorn.internal.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Тимур on 25.11.2016.
 */
public class FrameMain extends Frame {
    static String[][] data = {
            {"addins", "02.11.2006 19:15", "Folder", ""},
            {"AppPatch", "03.10.2006 14:10", "Folder", ""},
            {"assembly", "02.11.2006 14:20", "Folder", ""},
            {"Boot", "13.10.2007 10:46", "Folder", ""},
            {"Branding", "13.10.2007 12:10", "Folder", ""},
            {"Cursors", "23.09.2006 16:34", "Folder", ""},
            {"Debug", "07.12.2006 17:45", "Folder", ""},
            {"Fonts", "03.10.2006 14:08", "Folder", ""},
            {"Help", "08.11.2006 18:23", "Folder", ""},
            {"explorer.exe", "18.10.2006 14:13", "File", "2,93MB"},
            {"helppane.exe", "22.08.2006 11:39", "File", "4,58MB"},
            {"twunk.exe", "19.08.2007 10:37", "File", "1,08MB"},
            {"nsreg.exe", "07.08.2007 11:14", "File", "2,10MB"},
            {"avisp.exe", "17.12.2007 16:58", "File", "12,67MB"},
    };

    public static void createGui() {
        JFrame jFrame = new JFrame("Table");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        jFrame.setLayout(borderLayout);

        JPanel tablePanel = new JPanel();
        JPanel formPanel = new JPanel();

        String[] columnNames = {"Name", "Password", "Id", "Admin"};

        JTable jTable = new JTable(data,columnNames);
        JScrollPane jScrollPane = new JScrollPane(jTable);

        tablePanel.add(jTable);
        tablePanel.setSize(450,500);

        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel name = new JLabel("Name");
        JTextField nameField = new JTextField("AAAAAA");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        formPanel.add(name,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        formPanel.add(nameField,gridBagConstraints);


        JLabel password = new JLabel("Password");
        JTextField passwordField = new JTextField("AAAAAA");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        formPanel.add(password,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        formPanel.add(passwordField,gridBagConstraints);


        JLabel id = new JLabel("Id");
        JTextField idField = new JTextField("AAAAAA");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 10;
        formPanel.add(id,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        formPanel.add(idField,gridBagConstraints);



        jFrame.add(tablePanel,BorderLayout.WEST);
        jFrame.add(formPanel,BorderLayout.EAST);

        jFrame.getContentPane().add(jScrollPane);
        jFrame.setBounds(50,50,500,500);
        jFrame.setVisible(true);
        jFrame.pack();
    }


    public static void main(String[] argc) {
        createGui();
    }
    private final String USER_AGENT = "Mozilla/5.0";
    private String sendGet() throws Exception {

        String url = "http://localhost:3000/usersJ";

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

        JSONParser jp = new JSONParser();
        try {

            Object object = jp.parse(new FileReader("/home/azuharu/output.json"));
            JSONObject jso = (JSONObject) object;

            String city = (String) jso.get("city");
            String country = (String) jso.get("country");

            System.out.println("city: "+city);
            System.out.println("country: "+country);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
