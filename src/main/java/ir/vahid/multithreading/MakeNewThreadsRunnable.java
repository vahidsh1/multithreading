package ir.vahid.multithreading;

public class MakeNewThreadsRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(" Thread name : " + Thread.currentThread().getName() );
    }

    public static void main(String[] args) {
       Thread t2 =new Thread(new MakeNewThreadsRunnable());
       t2.start();

    }
}
