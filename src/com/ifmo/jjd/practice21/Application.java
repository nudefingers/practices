package com.ifmo.jjd.practice21;

public class Application {
    public static void main(String[] args) {

        Green green = new Green();
        Yellow yellow = new Yellow();
        Red red = new Red();

        Alarm greenA = new Alarm() {
            @Override
            public void tempChanged(int temp) {
                System.out.println("***green alarm*** " + temp);
            }
        };

        Alarm yellowA = new Alarm() {
            @Override
            public void tempChanged(int temp) {
                System.out.println("***yellow alarm*** " + temp);
            }
        };

        Alarm redA = new Alarm() {
            @Override
            public void tempChanged(int temp) {
                System.out.println("***red alarm*** " + temp);
            }
        };

        Sensor sensor = new Sensor(50);
        sensor.addObservers(green, yellow, red);

        System.out.println(red.getClass().getSimpleName());

        for (int i = 0; i < 10; i++) {
            sensor.changeTemp();
        }



    }
}
