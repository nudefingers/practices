package com.ifmo.jjd.practice23.reflection;

import com.ifmo.jjd.practice23.Text;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {

    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        /* Рефлексия - механизм, с помощью которого можно получать
        * информацию о классах, интерфейсах, полях и методах
        * во время выполнения программы.
        * Reflection API дает возможность создавать новые экземпляры классов,
        * получать и устанавливать значения свойств, вызывать методы. */

        Class<String> stringClass = String.class; // ссылка на класс String
        System.out.println(stringClass);

        Class<Integer> intClass = int.class;
        System.out.println(intClass);

        Class<Text> textClass = Text.class;
        System.out.println(textClass);

        Text text = new Text("Reflection");
        text.setText("Reflection API дает возможность создавать новые экземпляры классов");

        // ввиду полиморфизма объект text может быть экземпляром
        // подкласса Text
        Class<? extends Text> textClass2 = text.getClass();
        System.out.println(textClass2);

        textClass = Text.class;
        System.out.println(textClass.getName());
        System.out.println(textClass.getSimpleName());
        System.out.println(textClass.getPackageName());

        // интерфейсы, которые имплементирует класс
        Class<?>[] interfaces =  textClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        // родительский класс
        System.out.println(textClass.getSuperclass()); // Message
        System.out.println(textClass.getSuperclass().getSuperclass()); // Object
        System.out.println(textClass.getSuperclass().getSuperclass().getSuperclass()); // null

        textClass = Text.class;

        // доступ к компонентам класса
        // поля java.lang.reflect.Field;
        // поля класса, включая родительские, с модификатором
        Field[] fields = textClass.getFields();
        System.out.println(Arrays.toString(fields));

        // собственные поля класса с любым модификатором
        Field[] declaredFields = textClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // методы java.lang.reflect.Method;
        // методы класса, включая родительские, с модификатором public
        Method[] methods = textClass.getMethods();
        System.out.println(Arrays.toString(methods));

        System.out.println("!!!");
        Method[] declaredMethods = textClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));
        System.out.println("!!!");

        // конструкторы
        Constructor<?>[] declaredConstructor = textClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructor));

        // создание объекта
        Constructor<Text> textConstructor = textClass.getDeclaredConstructor(String.class);
        // Text text = new Text("Reflection");
        Text reflectText = textConstructor.newInstance("Reflection");
        // Text
        // private String text;
        Field field = textClass.getDeclaredField("text");

        field.setAccessible(true);
        // reflectText.text = "Reflection API дает возможность создавать ...";
        field.set(reflectText, "Reflection API дает возможность создавать " +
                "новые экземпляры классов");
        // System.out.println(reflectText.text);
        System.out.println(field.get(reflectText));
        /*public void setText(String text) {
            this.text = text;
        }*/
        Method method = textClass.getDeclaredMethod("setText", String.class);
        method.setAccessible(true);
        // reflectText.setText("Reflection API");
        method.invoke(reflectText, "Reflection API");


        System.out.println(field.getType()); // Class
        System.out.println(field.getName()); // String
        System.out.println(method.getGenericReturnType());
        System.out.println(Arrays.toString(method.getGenericParameterTypes()));
        System.out.println(Arrays.toString(method.getGenericExceptionTypes()));

        System.out.println(Modifier.isPrivate(field.getModifiers()));

        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-");
        toString(reflectText);
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-");

    }

    // TODO:
    // написать рефлексивный статический метод toString(Object o)
    // toString(reflectText);
    // Obj obj: int, boolean, String, User, String[], transient Some some
    public static void toString(Object o) throws InvocationTargetException, IllegalAccessException {
        String toToString = "{\n";

        Class<Object> oClass = (Class<Object>) o.getClass();
        Field[] fields = oClass.getFields();

        Method[] methods = oClass.getMethods();

        recToString(o, toToString, fields, methods);

        toToString = toToString + "}";

        System.out.println("*******************************");
        System.out.println(toToString);
    }

    public static String recToString(Object o, String toToString, Field[] fields, Method[] methods) throws InvocationTargetException, IllegalAccessException {

        for (Field field : fields) {

            System.out.println("*** " + field.getName());

            Class<? extends Field> fClass = field.getClass();
            Field[] fieldFields = fClass.getFields();
            if (fieldFields.length == 0) {
                Method method = Arrays.stream(methods)
                        .filter(m -> m.getName().equals("get" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1).toLowerCase()))
                        .findFirst()
                        .get();

                toToString = toToString + field.getName() + "\n";
                //toToString = toToString + method.invoke(o) + "\n";

            }
            else {
                System.out.println(2);
                toToString = toToString + "[\n";
                recToString(o, toToString, fieldFields, methods);
                toToString = toToString + "]\n";
            }
        }

        return toToString;
    }
}
