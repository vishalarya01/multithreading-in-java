package multithreading.ProducerConsumer;

public class ProducerConsumerProblemDemo {

    public static void main(String[] args) {
        System.out.println("Main starting");


        Thread thread1 = new Thread(()->{
            try{
                Thread.sleep(1);
                for (int i = 1000; i>0; i--);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"States");

        thread1.start();

        while (true){
            Thread.State state = thread1.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED) break;
        }

    }
}
