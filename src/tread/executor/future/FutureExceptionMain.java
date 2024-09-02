package tread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureExceptionMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");
        Future<Integer> fu = es.submit(new ExCallable());
        sleep(1000);

        try {
            log("future.get() 호출시도, future.state(): " + fu.state());
            Integer result = fu.get();
            log("result value = "+ result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log("e = " + e);
            Throwable cause = e.getCause();
            log("cause = " + cause);
        }


    }

    static class ExCallable implements Callable<Integer> {
        @Override
        public Integer call(){
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }
}
