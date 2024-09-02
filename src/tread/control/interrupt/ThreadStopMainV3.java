package tread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 = " + thread.isInterrupted());

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태 2 = "+ Thread.currentThread().isInterrupted());
            log("자원 정리");
            log("자원 종료");

        }
    }
}
