package multithreading;

public class ThreadDeadlockDemo {

    public static void main(String[] args) {
        System.out.println("Main starting");

        String lock1 = "abc";
        String lock2 = "xyz";

        Thread thread1 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("lock acquired");
                }
            }
        },"thread1");

        // for deadlock just reverse the lock in the thread2
        Thread thread2 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("lock acquired");
                }
            }
        },"thread2");

        thread1.start();
        thread2.start();
    }
}
