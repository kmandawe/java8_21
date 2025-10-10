package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
  private int balance = 50;

  public int getBalance() {
    return balance;
  }

  public void withdraw(int amount) {
    balance -= amount;
  }
}

public class RaceCondition implements Runnable {
  private static Lock lock = new ReentrantLock();

  private BankAccount account = new BankAccount();

  public static void main(String[] args) {
    Runnable r = new RaceCondition();
    Thread john = new Thread(r);
    Thread mary = new Thread(r);
    john.setName("John");
    mary.setName("Mary");
    john.start();
    mary.start();
  }

  @Override
  public void run() {
    for (int i = 1; i <= 5; i++) {
      makeWithdrawal(10);
      if (account.getBalance() < 0) {
        System.out.println("Account is overdrawn!");
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  //  private synchronized void makeWithdrawal(int amount) {
  private void makeWithdrawal(int amount) {
    try {
      lock.lock();
      if (account.getBalance() >= amount) {
        System.out.println(
            Thread.currentThread().getName() + ". Balance BEFORE " + account.getBalance());
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        account.withdraw(amount);
        System.out.println(
            Thread.currentThread().getName() + ". Balance AFTER " + account.getBalance());
      } else {
        System.out.println(
            Thread.currentThread().getName()
                + " is unable to withdraw"
                + " as balance is "
                + account.getBalance());
      }
    } finally {
      lock.unlock();
    }
  }
}
