package com.ifmo.jjd.practice23;

import java.time.LocalDateTime;

public class Message implements Comparable<Message>{
    public String sender;
    private LocalDateTime sent;

    public Message(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getSent() {
        return sent;
    }

    public void setSent() {
        this.sent = LocalDateTime.now();
    }

    @Override
    public int compareTo(Message o) {
        return sent.compareTo(o.sent);
    }
}
