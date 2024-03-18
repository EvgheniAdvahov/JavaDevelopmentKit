package org.example;

public class Philosoph extends Thread {

    Fork leftFork;
    Fork rightFork;

    private String name;

    public Philosoph(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void think() {
        System.out.println("Thinking " + name);
    }

    public void eat() {
        if (!leftFork.isInUse() && !rightFork.isInUse()) {
            System.out.println("leftFork.isInUse() = " + leftFork.isInUse());
            System.out.println("rightFork.isInUse() = " + rightFork.isInUse());
            synchronized (leftFork) {
                System.out.println(name + "took " + leftFork.getForkName());
                synchronized (rightFork) {
                    System.out.println(name + "took " + rightFork.getForkName());
                }
            }
        }
        System.out.println("Eating " + name + " " + leftFork.isInUse() + " " + rightFork.isInUse());
    }

    @Override
    public void run() {
        eat();
        think();
    }
}
