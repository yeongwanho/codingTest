package tread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> fu = executorService.submit(new MyCallable());
        Integer result = fu.get();
        log("result value = "+ result);
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