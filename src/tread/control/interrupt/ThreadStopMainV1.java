package tread.control.interrupt;

import util.MyLogger;
import util.ThreadUtils;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
        sleep(4000);
        log("작업 중단 지시 runFlag = false");
        task.runFlag=false;
    }

    static class MyTask implements Runnable{

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while(runFlag){
                log("작업 중");
                sleep(3000);
            }

        }
    }
}
