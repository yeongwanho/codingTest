package tread.control;

import tread.start.HelloRunnable;
import util.MyLogger;

import static util.MyLogger.*;

public class TreadInfoMain {
    public static void main(String[] args) {
        // main 스레드
        Thread thread = Thread.currentThread();
        log("mainThread = " +thread);
        log("mainThread.threadId()  = " +thread.threadId());
        log("mainThread.getName() = " +thread.getName());
        // 우선순위 기본 5
        log("mainThread.getPriority() = " +thread.getPriority());
        log("mainThread.getThreadGroup() = " +thread.getThreadGroup());
        log("mainThread.getState() = " +thread.getState());

        // main 스레드
        Thread myThread = new Thread(new HelloRunnable(),"myThread");
        log("mainThread = " +myThread);
        log("mainThread.threadId()  = " +myThread.threadId());
        log("mainThread.getName() = " +myThread.getName());
        // 우선순위 기본 5
        log("mainThread.getPriority() = " +myThread.getPriority());
        log("mainThread.getThreadGroup() = " +myThread.getThreadGroup());
        log("mainThread.getState() = " +myThread.getState());


    }
}
