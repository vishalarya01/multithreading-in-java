package multithreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    private int capacity;
    private Queue<Integer> queue;
    public MyQueue(int capacity){
        queue = new LinkedList<>();
        capacity = capacity;
    }

    public boolean add(int item){
        synchronized (queue){

            while (queue.size() == capacity){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(item);
            queue.notifyAll(); // notify all the thread that are in the wait state
            return true;

        }

    }
    public int remove(){

        synchronized (queue){

            while (queue.size() == 0){
                // thread has to wait till any other thread add element to the queue
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            int ele = queue.poll();
            queue.notifyAll();
            return ele;

        }

    }

}
