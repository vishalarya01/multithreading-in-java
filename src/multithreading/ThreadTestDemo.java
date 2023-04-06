package multithreading;

public class ThreadTestDemo {

    public static void main(String[] args) {

        System.out.println("Main thread is starting");
        Thread thread1 = new MyFirstThread("thread1");


        // by implementing runnable interface, passing the object of runnable interface to the
        // constructor of thread class
//        Thread thread2 = new Thread(new MySecondThread(),"thread2");


        // can use lambda also like this

        Thread thread2 = new Thread(() -> {
            for (int i =0; i<5; i++){
                System.out.println("inside "+ Thread.currentThread()+ " "+ i);
            }
        },"thread2");

        // setDaemon(true) to see the functionality - if no user thread is running,
        // then JVM may terminate Daemon thread

        thread1.setDaemon(false);
        thread1.start();
        thread2.start();



        System.out.println("Main thread is exiting");

        // this is actual thread class
        // new Thread().run();
    }
}
