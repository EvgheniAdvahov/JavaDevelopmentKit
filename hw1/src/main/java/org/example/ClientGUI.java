package org.example;

import org.example.client.ClientList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientGUI extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("ivan_igorevich");
    private final JPasswordField tfPassword = new JPasswordField("1234");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private boolean authentificated = false;


    ClientGUI(ServerWindow serverWindow) {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWindow.isServerWorking()) {
                    authentificated = true;
                    log.append("Вы успешно подключились\n\n");
                    panelTop.setVisible(false);

                    try (BufferedReader reader = new BufferedReader(new FileReader("log.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            log.append(line + "\n");
                        }
                    } catch (IOException m) {
                        m.printStackTrace();
                    }
                } else {
                    log.append("Подключение не удалось" + "\n");
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (authentificated) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
                        writer.append(tfLogin.getText()).append(": ").append(tfMessage.getText()).append("\n");
                    } catch (IOException m) {
                        m.printStackTrace();
                    }

                    for (ClientGUI clientGUI : ClientList.allClientList) {
                        if (clientGUI.authentificated) {
                            clientGUI.log.append(tfLogin.getText() + ": " + tfMessage.getText() + "\n");
                        }
                    }

                    serverWindow.addLog(tfLogin.getText() + ": " + tfMessage.getText() + "\n");

                    tfMessage.setText(null);
                }
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);


        setResizable(false);
        setVisible(true);

        ClientList.allClientList.add(this);
        getRootPane().setDefaultButton(btnSend);
    }

    public void changeState() {
        if (authentificated) {
            panelTop.setVisible(true);
            log.append("Вы были отключенны от сервера\n");
        }
    }

}
