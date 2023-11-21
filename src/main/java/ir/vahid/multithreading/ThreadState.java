package ir.vahid.multithreading;

public class ThreadState extends Thread {
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
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
