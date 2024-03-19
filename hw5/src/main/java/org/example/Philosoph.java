package org.example;

import java.util.concurrent.CountDownLatch;

public class Philosoph extends Thread {


    CountDownLatch cdl = new CountDownLatch(10);
    Fork leftFork;
    Fork rightFork;

    private String name;

    public Philosoph(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() throws InterruptedException {
        synchronized (leftFork) {
            synchronized (rightFork) {
//                Thread.sleep(1000);
                System.out.println("Покушал " + name + " думает, в тоже время вернул вилку" + leftFork.getForkName() + " и " + rightFork.getForkName());
                leftFork.setInUse(false);
                rightFork.setInUse(false);
//                cdl.countDown();
            }
        }

    }

    public void eat() throws InterruptedException {
        synchronized (leftFork) {
            synchronized (rightFork) {
                while (true) {
                    if (!leftFork.isInUse() && !rightFork.isInUse()) {
                        leftFork.setInUse(true);
                        rightFork.setInUse(true);
                        System.out.println("Кушает " + name + " взял вилку " + leftFork.getForkName() + " и " + rightFork.getForkName());
//                        Thread.sleep(10);
                        think();
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void run() {
//        while (true) {
            try {
                eat();
//                think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
//            }
            }
//        }
    }
}