package com.ifmo.jjd.practice13.message;

import com.ifmo.jjd.practice13.employee.utils.Randoms;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
        //ArrayList<Conformity> countPriority = new ArrayList<>(Message.MessagePriority.values().length);
        ArrayList<Conformity<Message.MessagePriority>> countPriority = new ArrayList<>();

        for (Message.MessagePriority elem : Message.MessagePriority.values()) {
            //countPriority.set(elem.ordinal(), new Conformity(elem));
            countPriority.add(elem.ordinal(), new Conformity(elem));
            for (Message msg : messageList) {
                 if (elem.equals(msg.getPriority())) {
                     countPriority.get(elem.ordinal()).setCount(countPriority.get(elem.ordinal()).getCount() + 1);
                 }
            }
        }
        System.out.println(countPriority);

    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        ArrayList<Conformity<Integer>> countCode = new ArrayList<>();
        ArrayList<Integer> codes = new ArrayList<>();

        for (Message msg: messageList) {
            if (!codes.contains(msg.getCode())) {
                codes.add(msg.getCode());
                countCode.add(new Conformity<>(msg.getCode(), 1));
            }
            else {
                countCode.get(codes.indexOf(msg.getCode()))
                        .setCount(countCode.get(codes.indexOf(msg.getCode())).getCount() + 1);
            }

        }
        System.out.println(countCode);

    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> uniqueMsg = new HashSet<>();
        uniqueMsg.addAll(messageList);

        System.out.println(uniqueMsg.size());

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        ArrayList<Message> uniqueMsg = new ArrayList();
        for (Message message : messageList) {
            if (!uniqueMsg.contains(message)) {
                uniqueMsg.add(message);
            }
        }
        return uniqueMsg;
    }

    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
        //  метод должен вернуть новую коллекцию
        ArrayList<Message> copyMsg = new ArrayList();

        for (Message message : messageList) {
            if (message.getPriority().equals(priority)) {
                copyMsg.add(message);
            }
        }
        return copyMsg;
    }

    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
        //  метод должен вернуть новую коллекцию
        ArrayList<Message> copyMsg = new ArrayList();

        for (Message message : messageList) {
            if (!message.getPriority().equals(priority)) {
                copyMsg.add(message);
            }
        }
        return copyMsg;

    }

    public static void main(String[] args) {
        List<Message> messages = Message.MessageGenerator.generate(34);
        System.out.println(messages);
        System.out.println("*******");

        // вызов методов
        System.out.println("Подсчитать количество сообщений для каждого приоритета:");
        countEachPriority(messages);
        System.out.println("*******");

        System.out.println("Подсчитать количество сообщений для каждого кода сообщения:");
        countEachCode(messages);
        System.out.println("*******");

        System.out.println("Подсчитать количество уникальных сообщений:");
        uniqueMessageCount(messages);
        System.out.println("*******");

        System.out.println("вернуть только неповторяющиеся сообщения и в том порядке,\n" +
                "в котором они встретились в первоначальном списке:");
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        System.out.println("*******");

        System.out.println("создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом\n" +
                "метод должен вернуть новую коллекцию:");
        Random random = new Random();
        System.out.println(copyEach(messages,
                Message.MessagePriority.getPriority(random.nextInt(Message.MessagePriority.values().length))));
        System.out.println("*******");

        System.out.println("создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет\n" +
                "метод должен вернуть новую коллекцию:");
        System.out.println(copyOther(messages,
                Message.MessagePriority.getPriority(random.nextInt(Message.MessagePriority.values().length))));
        System.out.println("*******");




    }
}
