package tread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static tread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("== 초기 상태 == ");
        printState(es);
        es.execute(new RunnableTask("task A"));
        es.execute(new RunnableTask("task B"));
        es.execute(new RunnableTask("task C"));
        es.execute(new RunnableTask("task D"));
        log("== 작업 수행 중 ==");
        printState(es);

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);
        es.close();
        sleep(100);
        log("== showdown==");
        printState(es);
    }
}
