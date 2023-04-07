package multithreading;

public class MyFirstThread extends Thread{


    public MyFirstThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i =0; i<5; i++){
            System.out.println("inside "+ Thread.currentThread()+ " "+ i);
        }
    }
}
