/**
 * Created by Тимур on 09.12.2016.
 */

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.*;

import java.io.IOException;
import java.util.*;

public class Server extends Thread {
    com.esotericsoftware.kryonet.Server server;
    HashMap<Connection, String> connectionsList = new HashMap<Connection, String>();

    public Server() throws IOException {
        server = new com.esotericsoftware.kryonet.Server();
        server.start();
        server.bind(22222, 22223);
        Kryo kryo = server.getKryo();
        kryo.register(SomeRequest.class);
        kryo.register(SomeResponse.class);
        kryo.register(LinkedList.class);
        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof SomeRequest) {
                    SomeRequest request = (SomeRequest) object;
                    if (request.getText().contains("___")) {
                        connectionsList.put(connection, request.getText().split("___")[1]);
                    }
                    if (!connectionsList.containsKey(connection)) {
                        SomeResponse response = new SomeResponse();
                        response.setText("You're welcome.");
                        connection.sendTCP(response);
                    } else {
                        Set set = connectionsList.keySet();
                        Iterator iterator = set.iterator();
                        LinkedList<SomeResponse> someResponseLinkedList = new LinkedList<SomeResponse>();
                        while (iterator.hasNext()){
                            SomeResponse response = new SomeResponse();
                            Connection con = (Connection) iterator.next();
                            response.setText(connectionsList.get(con) +": " + request.getText());
                            someResponseLinkedList.add(response);
                        }
                        connection.sendTCP(someResponseLinkedList);

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


    public com.esotericsoftware.kryonet.Server getServer() {
        return server;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.start();
    }
}
