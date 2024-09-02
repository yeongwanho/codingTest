package tread.start;

import util.MyLogger;

import static util.MyLogger.*;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("main() start");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        log("main() end");

    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log(Thread.currentThread().getName() +" : run()");
        }
    }

}
