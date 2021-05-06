package com.ifmo.jjd.pracrice21;

public class Yellow implements Alarm{
    public Yellow() {}

    @Override
    public void tempChanged(int temp) {
        System.out.println("***yellow alarm*** " + temp);
    }
}
