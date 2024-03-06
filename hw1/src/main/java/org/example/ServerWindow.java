package org.example;

import org.example.client.ClientList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JPanel panelTop = new JPanel(new GridLayout(1,2));
    private final JPanel panelBottom = new JPanel(new GridLayout(1,2));

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private JTextArea log = new JTextArea();
    private boolean isServerWorking;



    public boolean isServerWorking() {
        return isServerWorking;
    }

    public ServerWindow() {
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                log.append("Сервер остановлен \n");
                System.out.println("Server stopped " + isServerWorking + "\n");
                for (ClientGUI clientGUI : ClientList.allClientList) {
                    clientGUI.changeState();
                }

            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                log.append("Сервер запущен!\n");
                System.out.println("Server started " + isServerWorking + "\n");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Chat server");
        setAlwaysOnTop(true);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        panelBottom.add(btnStart);
        panelBottom.add(btnStop);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        panelTop.add(scrollLog);

        add(panelTop, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);



        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void addLog(String s) {
        this.log.append(s);
    }
}