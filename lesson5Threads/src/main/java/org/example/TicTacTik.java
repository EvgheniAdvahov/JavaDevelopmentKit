package org.example;

import java.util.concurrent.Semaphore;

public class TicTacTik extends Thread {
    private static Semaphore semaphore = new Semaphore(1);
    private static int turn = 1;
    private static final int MAX_TURNS = 3;

    public static void main(String[] args) {
        TicTacTik tic = new TicTacTik("1");
        TicTacTik tac = new TicTacTik("2");
        TicTacTik tik = new TicTacTik("3");

        tic.start();
        tac.start();
        tik.start();

    }

    String element;

    public TicTacTik(String element) {
        this.element = element;
    }


    private void myPrint() {
            System.out.print(element + " ");
    }

    @Override
    public void run() {
        while (true) {
                try {
                    semaphore.acquire();
                    if (element.equals(Integer.toString(turn))) {
                        myPrint();
                        turn = (turn % MAX_TURNS) + 1; // Move to the next thread's turn
                        Thread.sleep(300); // Simulate work
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
            }
        }
    }

}
