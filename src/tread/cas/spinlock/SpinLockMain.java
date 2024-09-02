package tread.cas.spinlock;

import static util.MyLogger.log;

public class SpinLockMain {
    public static void main(String[] args) {

        SpinLock spinLockBad = new SpinLock();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                spinLockBad.lock();
                try {
                    log("비즈니스 로직 실행");
                } finally {
                    spinLockBad.unlock();
                }
            }
        };
        Thread thread1 = new Thread(runnable,"Thread - 1");
        Thread thread2 = new Thread(runnable,"Thread - 2");

        thread1.start();
        thread2.start();


    }
}
