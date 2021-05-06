package com.ifmo.jjd.pracrice21;

public class Application {
    public static void main(String[] args) {
        Green green = new Green();
        Yellow yellow = new Yellow();
        Red red = new Red();

        Sensor sensor = new Sensor(50);
        sensor.addObservers(green, yellow, red);

        System.out.println(red.getClass().getSimpleName());

        for (int i = 0; i < 10; i++) {
            sensor.changeTemp();
        }



    }
}
