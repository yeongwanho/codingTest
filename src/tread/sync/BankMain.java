package tread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccountV5(1000);

        Thread thread1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread thread2 = new Thread(new WithdrawTask(account, 800), "t2");
        thread1.start();
        thread2.start();

//        sleep(500);

        log("t1 state: "+ thread1.getState());
        log("t2 state: "+ thread2.getState());



        thread2.join();
        thread1.join();

        log("최종 잔액: " + account.getBalance());
    }
}
