package org.example;

public class Main {

    public static void main(String[] args) {
        Fork fork1 = new Fork("fork1");
        Fork fork2 = new Fork("fork2");
        Fork fork3 = new Fork("fork3");
        Fork fork4 = new Fork("fork4");
        Fork fork5 = new Fork("fork5");

        Philosoph philosoph1 = new Philosoph("Philosoph1",fork1,fork5);
        Philosoph philosoph2 = new Philosoph("Philosoph2",fork2,fork1);
        Philosoph philosoph3 = new Philosoph("Philosoph3",fork3,fork2);
        Philosoph philosoph4 = new Philosoph("Philosoph4",fork4,fork3);
        Philosoph philosoph5 = new Philosoph("Philosoph5",fork5,fork4);

        philosoph1.start();
        philosoph2.start();
        philosoph3.start();
        philosoph4.start();
        philosoph5.start();

        System.out.println("fork1 "+fork1.isInUse());
//        System.out.println(fork2.isInUse());
//        System.out.println(fork3.isInUse());
//        System.out.println(fork4.isInUse());
//        System.out.println(fork5.isInUse());

    }
}