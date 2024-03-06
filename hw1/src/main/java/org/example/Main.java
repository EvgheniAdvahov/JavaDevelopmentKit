package org.example;

import org.example.client.ClientList;

public class Main {

    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);

    }
}