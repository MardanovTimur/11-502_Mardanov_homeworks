import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Тимур on 09.12.2016.
 */
public class Client extends Thread {
    private Scanner scanner = new Scanner(System.in);
    private com.esotericsoftware.kryonet.Client client;
    private String name = "Unknown";
    SomeRequest request = new SomeRequest();

    public Client() throws IOException {

        client = new com.esotericsoftware.kryonet.Client();
        client.start();
        client.connect(5000, "127.0.0.1", 22222, 22223);
        Kryo kryo = client.getKryo();
        kryo.register(SomeRequest.class);
        kryo.register(SomeResponse.class);
        kryo.register(LinkedList.class);

        if (name.equals("Unknown")) {
            System.out.print("Username___");
            name = scanner.nextLine();
            request.setText("Username___" + name);
            client.sendTCP(request);
        }

        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                request.setText(scanner.nextLine());
                connection.sendTCP(request);


                if (object instanceof LinkedList) {
                    LinkedList<SomeResponse> response = (LinkedList<SomeResponse>) object;
                    for (SomeResponse smth : response) {
                        System.out.println(smth.getText());
                    }
                }

            }

        });
    }

    @Override
    public void run() {
        try {
            sleep(2000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.start();

    }
}
