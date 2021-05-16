package com.ifmo.jjd.practice23.annotations;


import com.ifmo.jjd.practice23.Point;
import com.ifmo.jjd.practice23.Text;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class AnnotationsLesson {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Point> pointClass = Point.class;

        Annotation[] annotations = pointClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        if (pointClass.isAnnotationPresent(Component.class)) {
            Component component = pointClass.getDeclaredAnnotation(Component.class);
            System.out.println(component.fileName());
            System.out.println(component.version());
        }
        // import java.lang.reflect.Field;
        Field[] fieldsP = pointClass.getDeclaredFields();
        for (Field field: fieldsP) {
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println(field.getType());
                System.out.println(field.getName());
            }
        }

        /*Set<Class<?>> classSet = new HashSet<>();
        classSet.add(Point.class);
        classSet.add(Text.class);*/

        // import java.util.Properties;
        Properties properties = new Properties();
        /*properties.setProperty("ip", "127.0.0.1");
        properties.setProperty("port", "8090");
        System.out.println(properties.getProperty("ip")); // "127.0.0.1"
        System.out.println(properties.getProperty("port")); // "8090"*/

        try (InputStream input = AnnotationsLesson.class
                .getClassLoader() // обращение к папке с ресурсами
                .getResourceAsStream("point.properties")){
            properties.load(input);

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
        }

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-");
        // TODO:
        // если класс аннотирован Component:
        // создать объект данного класса
        // если поле отмечено аннотацией Required,
        // установить значение (из properties файла) данного поля,
        // используя сеттер
        if (pointClass.isAnnotationPresent(Component.class)) {
            Component component = pointClass.getDeclaredAnnotation(Component.class);
            String fileName = component.fileName();

            Constructor<Point> pointConstructor = pointClass.getDeclaredConstructor();
            Point reflectPoint = pointConstructor.newInstance();

            Method[] declaredMethods = pointClass.getDeclaredMethods();

            Field[] fields = pointClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Required.class)) {
                    Method method = Arrays.stream(declaredMethods)
                            .filter(m -> m.getName().equals("set" + field.getName().toUpperCase()))
                            .findFirst()
                            .get();

                    method.invoke(reflectPoint, Integer.parseInt(properties.get(field.getName()).toString()));
                }
            }

            System.out.println(reflectPoint.getX());
            System.out.println(reflectPoint.getY());
        }

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-");

    }



}
