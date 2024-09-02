package tread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV4 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock(true);

    public BankAccountV4(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());
        // 잔고가 출금액 보다 적으면, 진행 하면 안됨
        lock.lock(); // ReentrantLock을  이용하여 Lock 걸기
        try {
            // == 임계영역 시작 ==
            log("[검증 시작] 출금액 : " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액: " + balance);
                return false;
            }

            // 잔고가 출금액보다 많으면, 진행
            log("[검증 완료] 출금액 : " + amount + ", 잔액: " + balance);
            sleep(1000); // 출금에 걸리는 시간으로 가정
            balance = balance - amount;
            log("[출금 완료] 출금액 : " + amount + ", 잔액: " + balance);

        } finally {
            lock.unlock();

        }

        // == 임계영역 종료 ==
        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
