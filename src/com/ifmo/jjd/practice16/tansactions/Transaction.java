package com.ifmo.jjd.practice16.tansactions;

public class Transaction {
    private String uuid;
    private long sum;
    private Account account;

    public Transaction(String uuid, long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public long getSum() {
        return sum;
    }

    public Account getAccount() {
        return account;
    }

    public String getAccountNumber() {
        return account.getNumber();
    }

    // TODO: добавить геттеры и сеттеры
}