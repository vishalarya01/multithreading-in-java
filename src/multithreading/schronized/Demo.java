package multithreading.schronized;

public class Demo {

    public static void main(String[] args) {

        System.out.println("Main starting");

        MyStack stack = new MyStack(5);

        new Thread(()-> {
            int count = 0;
            while (++count < 10){
                System.out.println("Pushed: "+stack.push(100));
            }
        },"pusher").start();

        new Thread(()-> {
            int count = 0;
            while (++count < 10){
                System.out.println("Popped: "+stack.pop());
            }
        },"popped").start();

        System.out.println("Main exiting");
    }
}
