package com.ifmo.jjd.practice26.transaction;

public class Transaction implements Runnable{
    private final Account src;
    private final Account dst;
    private int money;

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    // (account1, account2, 300)
// (account2, account1, 340)
    @Override
    public void run() {
        if (src.getBalance() >= money) {
            // вызываем один метод на выбор
        }
    }

    public void firstWay() {



        if (src.getUuid().compareTo(dst.getUuid()) > 0) {
            synchronized (src) {
                src.setBalance(src.getBalance() - money);
                synchronized (dst){
                    dst.setBalance(dst.getBalance() + money);
                }
            }
        } else {
            synchronized (dst) {
                dst.setBalance(dst.getBalance() + money);
                synchronized (src){
                    src.setBalance(src.getBalance() - money);
                }
            }
        }

    }

    public void secondWay() {
        try {
            synchronized (src) {
                src.setBalance(src.getBalance() - money);
            }
            synchronized (dst) {
                dst.setBalance(dst.getBalance() + money);
            }
        }
        catch (Exception e) {
            System.out.println("Транзакция не выполнена");
        };
    }
}