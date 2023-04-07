package multithreading;

public class ThreadJoinDemo {

    public static void main(String[] args) {

        System.out.println("Main starting");

        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread());
        },"My Thread");

        thread.start();

        // sequentially execute
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(thread.getPriority());
        System.out.println("main exiting");

    }
}
