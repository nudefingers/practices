package com.ifmo.jjd.practice21;

public class Green implements Alarm{
    public Green() {}

    @Override
    public void tempChanged(int temp) {
        System.out.println("***green alarm*** " + temp);
    }
}
