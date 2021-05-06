package com.ifmo.jjd.practice21;

public class Red implements Alarm{
    public Red() {}

    @Override
    public void tempChanged(int temp) {
        System.out.println("***red alarm*** " + temp);
    }
}
