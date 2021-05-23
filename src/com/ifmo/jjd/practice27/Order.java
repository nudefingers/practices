package com.ifmo.jjd.practice27;

import java.util.UUID;

public class Order {

    enum Status {
        CREATED,
        TAKEN,
        READY,
        CLOSED;
    }

    private UUID number;
    private Status status;

    public Order() {
        number = UUID.randomUUID();
        status = Status.CREATED;
    }

    public void setTaken() {
        status = Status.TAKEN;
    }

    public void setReady() {
        status = Status.READY;
    }

    public void setClosed() {
        status = Status.CLOSED;
    }

    public UUID getNumber() {
        return number;
    }
}
