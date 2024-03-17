package org.example.Test;

public class ThreadForTest implements Runnable {

    Integer value = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new ThreadForTest()).start();
        }
    }

    public synchronized void inc() {
        value++;
    }

    @Override
    public void run() {
        while (true) {
            try {
                inc();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "value is: " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
