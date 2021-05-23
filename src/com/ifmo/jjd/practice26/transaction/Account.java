package com.ifmo.jjd.practice26.transaction;

import java.util.UUID;

public class Account {
    private UUID uuid;
    private int balance;

    public Account(int balance) {
        this.balance = balance;
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}