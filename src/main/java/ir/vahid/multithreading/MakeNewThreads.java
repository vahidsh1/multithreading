package ir.vahid.multithreading;

import java.util.concurrent.Semaphore;

class Shared {
    public static int number=0;
}
public class MakeNewThreads extends Thread {
    Semaphore semaphore = new Semaphore(1);
    public void run(){
//        System.out.println(" Thread name : " + Thread.currentThread().getName());
//        System.out.println(" Thread State : " + Thread.currentThread().getState());
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for a permit.");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()  + " gets a permit.");
            for(int count=0;count<10;count++) {
                System.out.println("count number is : " + Shared.number + " " + Thread.currentThread().getName() + " available permit is: " + semaphore.availablePermits());
                Shared.number++;
                Thread.sleep(10);
            }
//            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " releases the permit.");
        semaphore.release();

    }

    public static void main(String[] args) {
        MakeNewThreads t1 = new MakeNewThreads();
        MakeNewThreads t2 = new MakeNewThreads();
        MakeNewThreads t3 = new MakeNewThreads();
        MakeNewThreads t4 = new MakeNewThreads();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
//        Semaphore semaphore = new Semaphore(2);
    }
}
