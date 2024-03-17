package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements  Runnable{

    private final AtomicInteger value;
    private CountDownLatch cdl;

    public Task(int left) {
        this.value = new AtomicInteger(left);
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

//    cинхронизировали функцию
//    public synchronized void inc() {
//        value++;
//    }

    //синхронизировали блок
//    public void inc() {
//        synchronized (Task.class){
//            value++;
//        }
//    }

    public  void inc() {
        value.incrementAndGet();
    }

    public int getValue() {
        return value.intValue();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            inc();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("(%s)",value);
    }
}
