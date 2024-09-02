package tread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        HelloThread helloThread = new HelloThread();
        helloThread.start();
    }
}
