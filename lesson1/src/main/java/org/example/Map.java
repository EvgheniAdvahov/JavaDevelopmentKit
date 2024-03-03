package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;

    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        repaint();
    }

    void startNewGame(int mode, int fSzx, int fSzY, int wLen) {
        System.out.printf("Mode: $d; \nSize: x =%d, y=%d; \nWin Length: %d",
                mode, fSzx, fSzY, wLen);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight / 4;
        cellWidth = panelWidth / 4;

        g.setColor(Color.BLACK);
        for (int h = 0; h < 4; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int w = 0; w < 4; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


    }
}
