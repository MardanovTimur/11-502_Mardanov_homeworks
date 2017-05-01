package ru.itis.inform.reg;

import ru.itis.inform.Controller;

/**
 * Created by alisa on 01.05.2017.
 */
public class ConnectorRegisterMain {

    public static void Connecting(Controller controller) {
        System.out.println("Connector.Connecting(): Called");
        controller.setLoginField("Bye World");
    }
}
