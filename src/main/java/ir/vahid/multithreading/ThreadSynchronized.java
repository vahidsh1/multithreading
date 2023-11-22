package ir.vahid.multithreading;

public class ThreadSynchronized extends Thread {
    Sender sender;
    private String msg;

    ThreadSynchronized(String msg, Sender sender) {
        this.msg = msg;
        this.sender = sender;
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

class Sender {
    public void send(String msg) throws InterruptedException {
        System.out.println("Sending\t" + msg);
        Thread.sleep(1000);
        System.out.println("\n" + msg + " Sent ");
    }
}

class SyncDemo {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Thread t1 = new ThreadSynchronized("Hi", sender);
        Thread t2 = new ThreadSynchronized("End", sender);
        // Start two threads of ThreadedSend type
        t1.start();
        t2.start();
        // wait for threads to end
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
//Explanation
//        In the above example, we choose to synchronize the Sender object inside the run() method of the ThreadedSend class.
//        Alternately, we could define the whole send() block as synchronized, producing the same result.
//        Then we don’t have to synchronize the Message object inside the run() method in ThreadedSend class.


//    Process Synchronization
//    Thread Synchronization
//        1. Process Synchronization in Java
//        Process Synchronization is a technique used to coordinate the execution of multiple processes. It ensures that the shared resources are safe and in order.
//
//        2. Thread Synchronization in Java
//        Thread Synchronization is used to coordinate and ordering of the execution of the threads in a multi-threaded program. There are two types of thread synchronization are mentioned below:
//
//        Mutual Exclusive
//        Cooperation (Inter-thread communication in Java)
//        Mutual Exclusive
//        Mutual Exclusive helps keep threads from interfering with one another while sharing data. There are three types of Mutual Exclusive mentioned below:
//
//        Synchronized method.
//        Synchronized block.
//        Static synchronization.