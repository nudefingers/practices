package com.ifmo.jjd.practice21;

public class Yellow implements Alarm{
    public Yellow() {}

    @Override
    public void tempChanged(int temp) {
        System.out.println("***yellow alarm*** " + temp);
    }
}
