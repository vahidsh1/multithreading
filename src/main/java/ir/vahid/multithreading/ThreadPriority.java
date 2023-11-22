package ir.vahid.multithreading;

public class ThreadPriority extends Thread{
    public void run(){
        System.out.println("Inside run method");
    }

    public static void main(String[] args) {
        ThreadPriority t1=new ThreadPriority();
        ThreadPriority t2=new ThreadPriority();
        ThreadPriority t3=new ThreadPriority();
        System.out.println("t1 thread priority is : " + t1.getPriority());
        System.out.println("t2 thread priority is : " + t2.getPriority());
        System.out.println("t3 thread priority is : " + t3.getPriority());

        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);
        System.out.println("t1 thread priority is : " + t1.getPriority());
        System.out.println("t2 thread priority is : " + t2.getPriority());
        System.out.println("t3 thread priority is : " + t3.getPriority());

// Main thread

        // Displays the name of
        // currently executing Thread
        System.out.println(
                "Currently Executing Thread : "
                        + Thread.currentThread().getName());

        System.out.println(
                "Main thread priority : "
                        + Thread.currentThread().getPriority());

        // Main thread priority is set to 10
        Thread.currentThread().setPriority(10);

        System.out.println(
                "Main thread priority : "
                        + Thread.currentThread().getPriority());
    }
}
