package com.ifmo.jjd.pracrice21;

import com.ifmo.jjd.practice13.employee.utils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

public class Sensor {
    public int temp;
    public int previousTemp = 0;
    private ArrayList<Alarm> alarms = new ArrayList<>();

    private final static int GREEN_ALARM_TEMP = 100;
    private final static int YELLOW_ALARM_TEMP = 300;
    private final static int RED_ALARM_TEMP = 600;

    private final static int ALARM_TEMP = 100;

    public Sensor(int temp) {
        this.temp = temp;
    }

    public void addObservers(Alarm... alarms) {
        this.alarms.addAll(Arrays.asList(alarms));
    }

    public void removeObservers(Alarm... alarms) {
        this.alarms.removeAll(Arrays.asList(alarms));
    }

    public void changeTemp() {
        previousTemp = temp;
        temp = 100 * Randoms.getRandomInt(10);

        System.out.println(previousTemp + "->" + temp);

        if (temp > previousTemp) {
            if (previousTemp < GREEN_ALARM_TEMP && temp >= GREEN_ALARM_TEMP) notify(temp, "Green");
            if (previousTemp < YELLOW_ALARM_TEMP && temp >= YELLOW_ALARM_TEMP) notify(temp, "Yellow");
            if (previousTemp < RED_ALARM_TEMP && temp >= RED_ALARM_TEMP) notify(temp, "Red");
        }
    }

    private void notify(int temp, String name) {
        alarms.stream()
                .filter(alarm -> alarm.getClass().getSimpleName().equals(name))
                .forEach(alarm -> alarm.tempChanged(temp));
    }

}
