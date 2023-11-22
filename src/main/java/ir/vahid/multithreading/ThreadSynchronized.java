package ir.vahid.multithreading;

public class ThreadSynchronized extends Thread {
    Sender sender;
    private String msg;
    ThreadSynchronized(String msg, Sender sender){
        this.msg=msg;
        this.sender=sender;
    }

    @Override
    public void run() {
        synchronized (sender) {
            try {
                sender.send(msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
class Sender{
    public void send (String msg) throws InterruptedException {
        System.out.println("Sending\t"+ msg);
        Thread.sleep(1000);
        System.out.println("\n" + msg + " Sent ");
    }
}
class SyncDemo {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Thread t1= new ThreadSynchronized("Hi",sender);
        Thread t2= new ThreadSynchronized("End",sender);
        // Start two threads of ThreadedSend type
        t1.start();
        t2.start();

    }
}