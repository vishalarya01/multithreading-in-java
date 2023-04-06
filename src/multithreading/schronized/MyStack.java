package multithreading.schronized;

public class MyStack {

    private int[] arr;
    private int stackTop;

    // we can use any object as a lock
    Object lock;

    public MyStack(int capacity) {
        arr = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

    // two ways - synchronized block and synchronized method
    // synchronized method - where is lock then ? internally it is current object i.e (this) as lock
    public synchronized boolean push(int ele){

        // internally synchronized methods use this template b
        // synchronized(this)
//        synchronized (lock) {
            if (isFull()) return false;

            ++stackTop;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            arr[stackTop] = ele;
            return true;
//        }

    }

    public int pop(){

        synchronized (lock) {
            if (isEmpty()) return Integer.MIN_VALUE;

            int ele = arr[stackTop];
            arr[stackTop] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            stackTop--;

            return ele;
        }
    }
    // in a class, if multiple synchronized method bounded by the same lock whichever thread has that lock
    // only that thread is able to execute all methods others thread will be blocked

    public boolean isEmpty(){
        return stackTop<0;
    }

    public boolean isFull(){
        return stackTop >= arr.length-1;
    }
}
