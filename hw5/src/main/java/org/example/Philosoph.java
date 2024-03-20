package org.example;

import java.util.concurrent.CountDownLatch;

public class Philosoph extends Thread {

    volatile Fork leftFork;
    volatile Fork rightFork;
    CountDownLatch cdl = new CountDownLatch(3);
    private String name;

    public Philosoph(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public CountDownLatch getCdl() {
        return cdl;
    }

    public void think() throws InterruptedException {
                System.out.println("Покушал " + name + " думает, в тоже время вернул вилку " + leftFork.getForkName() + " и " + rightFork.getForkName());
                leftFork.setInUse(false);
                rightFork.setInUse(false);
//                Thread.sleep(10);
                cdl.countDown();
    }

    public void eat() throws InterruptedException {
        while (true) {
            if (!leftFork.inUse && !rightFork.inUse) {
                synchronized (leftFork) {
                    synchronized (rightFork) {
                        leftFork.setInUse(true);
                        rightFork.setInUse(true);
                        Thread.sleep(1000);
                        System.out.println("Кушает " + name + " взял вилку " + leftFork.getForkName() + " и " + rightFork.getForkName());
                        Thread.sleep(1000);
                    }
                }
                break;
            }
        }
    }

    @Override
    public void run() {
        while (cdl.getCount() > 1) {
            try {
                eat();
                think();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " НАКУШАЛСЯ!!!!! ");
        cdl.countDown();
    }
}