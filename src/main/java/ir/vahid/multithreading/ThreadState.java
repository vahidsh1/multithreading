package ir.vahid.multithreading;

import static java.lang.Thread.sleep;

public class ThreadState implements Runnable {
    @Override
    public void run() {
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(
                "State of thread1 while it called join() method on thread2 -" + Test.thread1.getState());
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test implements Runnable {
    public static Thread thread1;
    public static Test obj;

    public static void main(String[] args) throws InterruptedException {
        obj = new Test();
        thread1 = new Thread(obj);
        // thread1 created and is currently in the NEW
        // state.
        System.out.println(
                "State of thread1 after creating it - "
                        + thread1.getState());
        thread1.start();

        // thread1 moved to Runnable state
        System.out.println(
                "State of thread1 after calling .start() method on it - "
                        + thread1.getState());
    }

    @Override
    public void run() {
        Thread thread2 = new Thread(new Test());
        System.out.println("State of thread1 while it called join() method on thread2 -" + thread2.getState());
        thread2.start();
        System.out.println(
                "State of thread2 after creating it - "
                        + thread2.getState());
        System.out.println(
                "State of thread2 after calling .start() method on it - "
                        + thread2.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(
                "State of thread2 after calling .sleep() method on it - "
                        + thread2.getState());

        try {
            // waiting for thread2 to die
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "State of thread2 when it has finished it's execution - "
                        + thread2.getState());
    }
}