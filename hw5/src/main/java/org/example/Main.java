package org.example;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Fork fork1 = new Fork("1");
        Fork fork2 = new Fork("2");
        Fork fork3 = new Fork("3");
        Fork fork4 = new Fork("4");
        Fork fork5 = new Fork("5");

        Philosoph philosoph1 = new Philosoph("Философ N1", fork1, fork5);
        Philosoph philosoph2 = new Philosoph("Философ N2", fork2, fork1);
        Philosoph philosoph3 = new Philosoph("Философ N3", fork3, fork2);
        Philosoph philosoph4 = new Philosoph("Философ N4", fork4, fork3);
        Philosoph philosoph5 = new Philosoph("Философ N5", fork5, fork4);

        System.out.println("Кушать подано!");
            philosoph1.start();
            philosoph2.start();
            philosoph3.start();
            philosoph4.start();
            philosoph5.start();
            while (
                    philosoph1.getCdl().getCount() > 0 ||
                    philosoph2.getCdl().getCount() > 0 ||
                    philosoph3.getCdl().getCount() > 0 ||
                    philosoph4.getCdl().getCount() > 0 ||
                    philosoph5.getCdl().getCount() > 0
            ){
                Thread.sleep(200);
            }
        System.out.println();
        System.out.println("ВСЕ философы покушали!!!!");


    }
}