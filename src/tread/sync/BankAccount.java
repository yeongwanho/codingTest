package tread.sync;

public interface BankAccount {

    //출금
    boolean withdraw(int amount);

    int getBalance();
}
