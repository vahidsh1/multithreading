package ir.vahid.multithreading;

import java.util.concurrent.Semaphore;

class Shared {
    public static int number=0;
}
public class MakeNewThreads extends Thread {
    Semaphore semaphore ;
public MakeNewThreads (Semaphore semaphore) {
    this.semaphore = semaphore;
}
    public void run(){
//        System.out.println(" Thread name : " + Thread.currentThread().getName());
//        System.out.println(" Thread State : " + Thread.currentThread().getState());
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for a permit.");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()  + " gets a permit.");
            for(int count=0;count<10;count++) {
                System.out.println("count number is : " + Shared.number + " " + Thread.currentThread().getName() + " available permit is: " + semaphore.getQueueLength());
                Shared.number++;
//                Thread.sleep(10);
            }
//            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " releases the permit.");
        semaphore.release();
        System.out.println(semaphore.availablePermits() + " numbers of available permits.");

    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        MakeNewThreads t1 = new MakeNewThreads(semaphore);
        MakeNewThreads t2 = new MakeNewThreads(semaphore);
        MakeNewThreads t3 = new MakeNewThreads(semaphore);
        MakeNewThreads t4 = new MakeNewThreads(semaphore);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
