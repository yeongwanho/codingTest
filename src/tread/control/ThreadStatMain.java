package tread.control;

import util.MyLogger;

import static util.MyLogger.*;

public class ThreadStatMain {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start() ");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3= "+ thread.getState());
        Thread.sleep(4000);
        log("myThread.state4= "+ thread.getState());
        log("end");

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState());
                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");
                log("myThread.sate4 = "+Thread.currentThread().getState());
                log("end");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
