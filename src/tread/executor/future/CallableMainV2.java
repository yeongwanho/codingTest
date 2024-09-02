package tread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        log("submit() 호출");
        Future<Integer> fu = executorService.submit(new MyCallable());
        log(" future.get() [블로킹] 메서드 호출 시작 -> main스레드 WAITING");
        Integer result = fu.get();
        log(" future.get() [블로킹] 메서드 호출 완료 -> main스레드 RUNNABLE");
        log("result value = "+ result);
        log("future 완료, future = "+ result);
        executorService.close();
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("Callable 완료");
            return value;
        }
    }
}
