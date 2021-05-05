package com.ifmo.jjd.practice16.pupils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PupilTask {
    public static void main(String[] args) {

        List<Pupil> pupils = Pupil.getInstances(20);
        System.out.println(pupils.toString());
        // Используя Stream API:


        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> genderGroups = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.toCollection(ArrayList::new)));
        System.out.println("\n" + "genderGroups:");
        System.out.println(genderGroups);


        // 2. Найти средний возраст учеников
        Double averageAge = pupils.stream()
                .mapToDouble(pupil -> ChronoUnit.DAYS.between(pupil.getBirth(), LocalDate.now().atStartOfDay()))    //Function.identity() ???
                .average() // среднее значение
                .orElse(0); // вынимаем из Optional conteiner

        System.out.println("\n" + "Средний возраст учеников:");
        System.out.println(averageAge + " дней");


        // 3. Найти самого младшего ученика
        Pupil yongerPupil = pupils.stream()
                .max(Comparator.comparing(Pupil::getBirth))
                .orElse(Pupil.getInstance());
        System.out.println("\n" + "Самый младший ученик:");
        System.out.println(yongerPupil);


        // 4. Найти самого взрослого ученика
        Pupil olderPupil = pupils.stream()
                .min(Comparator.comparing(Pupil::getBirth))
                .orElse(Pupil.getInstance());
        System.out.println("\n" + "Самый старший ученик:");
        System.out.println(olderPupil);


        // 5. Собрать учеников в группы по году рождения
        Map<Integer, ArrayList<Pupil>> pupilsByYear = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getBirthYear,
                        Collectors.toCollection(ArrayList::new)));
        System.out.println("\n" + "Группы по году рождения:");
        System.out.println(pupilsByYear);


        // 6. Оставить учеников с неповторяющимися именами, имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]
        Map<String, ArrayList<Pupil>> homonym = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getName,
                        Collectors.toCollection(ArrayList::new)));
        System.out.println("\n" + "Тёзки:");
        System.out.println(pupilsByYear);


        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Pupil> byFemaleByDateByName = pupils.stream()
                .sorted(Comparator.comparing(Pupil::getGender)
                        .thenComparing(Pupil::getBirth)
                        .thenComparing(Pupil::getName).reversed())
                .collect(Collectors.toList());
        System.out.println("\n" + "Сортировка:");
        System.out.println(byFemaleByDateByName);


        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        int n = 7;
        int m = 9;
        List<Pupil> yearBeetween = pupils.stream()
                .filter(pup -> (LocalDateTime.now().getYear() - pup.getBirthYear() >= n) && (LocalDateTime.now().getYear() - pup.getBirthYear() <= m))
                .collect(Collectors.toList());
        System.out.println("\n" + "Возраст в интервале:");
        System.out.println(yearBeetween);


        // 9. Собрать в список всех учеников с именем=someName
        String someName = "Никки";
        List<Pupil> bySomeName = pupils.stream()
                .filter(pup -> pup.getName().equals(someName))
                .collect(Collectors.toList());
        System.out.println("\n" + "Имя == " + someName + ":");
        System.out.println(bySomeName);


        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> byGenderAgeSum = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.summingInt(Pupil::getAge)));
        System.out.println("\n" + "Суммарный возраст по полу:");
        System.out.println(byGenderAgeSum);

    }
}

















