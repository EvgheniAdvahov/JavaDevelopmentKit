package org.example;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {


        Fork fork1 = new Fork("1");
        Fork fork2 = new Fork("2");
        Fork fork3 = new Fork("3");
        Fork fork4 = new Fork("4");
        Fork fork5 = new Fork("5");

        Philosoph philosoph1 = new Philosoph("Philosopher N1", fork1, fork5);
        Philosoph philosoph2 = new Philosoph("Philosopher N2", fork2, fork1);
        Philosoph philosoph3 = new Philosoph("Philosopher N3", fork3, fork2);
        Philosoph philosoph4 = new Philosoph("Philosopher N4", fork4, fork3);
        Philosoph philosoph5 = new Philosoph("Philosopher N5", fork5, fork4);

            philosoph1.start();
            philosoph2.start();
            philosoph3.start();
            philosoph4.start();
            philosoph5.start();



//        System.out.println("fork1 "+fork1.isInUse());
//        System.out.println(fork2.isInUse());
//        System.out.println(fork3.isInUse());
//        System.out.println(fork4.isInUse());
//        System.out.println(fork5.isInUse());
    }
}