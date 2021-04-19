package com.ifmo.jjd.practice14;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(loginsInCity(firstTaskMap, city));


        // TODO:: дан список слов (например, words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(sameWords((ArrayList)words));


        // TODO:: дана мапа (например, customerMap).
        //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(ageRange(customerMap,23, 67));



        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова:
        //  3 - [the, war, jar, get, met...],
        //  в другую 2 - [on, up, no, of...] и тд
        //  результат сохранить в Map<Integer, ArrayList>
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // 1.
        System.out.println(frequencyOfOccurrence(text, "it"));

        // 2.
        System.out.println(lettersCount(text));

        // 3.
        System.out.println(mostCommonWords(text));

    }


/*      написать статический метод, который принимает на вход мапу (например, firstTaskMap) и город (например, city),
        формирует и возвращает список (List) логинов, которые соответствуют переданному городу */
    public static List loginsInCity(HashMap<String, String> firstTaskMap, String city) {
        ArrayList <String> logins = new ArrayList<>();
        for (Map.Entry<String, String> entry: firstTaskMap.entrySet()) {
            if (entry.getValue().equals(city)) {
                logins.add(entry.getKey());
            }
        }
        return logins;
    }


/*      дан список слов (например, words).
        Написать статический метод, который будет возвращать количество одинаковых слов с списке
        в виде Map<String, Integer>, где String - слово и Integer - количество повторений */
    public static HashMap<String, Integer> sameWords (ArrayList<String> words) {
        HashMap<String, Integer> sameWords = new HashMap<>();
        for (String word : words) {
            sameWords.put(word, sameWords.getOrDefault(word, 0) + 1 );
        }
        return sameWords;
    }


/*      дана мапа (например, customerMap).
        Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to) */
    public static HashMap<String, Customer> ageRange (HashMap<String, Customer> customerMap, int from, int to) {
        HashMap<String, Customer> customerAgeRangeMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
            if (entry.getValue().getAge() >= from && entry.getValue().getAge() < to) {
                customerAgeRangeMap.put(entry.getKey(), entry.getValue());
            }
        }
        return customerAgeRangeMap;
    }


        //работа с текстом
    // 1.
    public static int frequencyOfOccurrence (String text, String word) {
        String[] words = text.split(" ");
        int count = 0;
        for (String s : words) {
            if (s.compareToIgnoreCase(word) == 0) count++;
        }
        return count;
    }

    // 2.
    public static HashMap<Integer, HashSet<String>> lettersCount (String text) {
        HashMap<Integer, HashSet<String>> lettersCounts = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            HashSet<String> wordsByLenght = new HashSet<>();
            wordsByLenght = lettersCounts.getOrDefault(word.length(), wordsByLenght);
            wordsByLenght.add(word);
            lettersCounts.put(word.length(), wordsByLenght);
        }
        return lettersCounts;
    }

    // 3.
    public static String mostCommonWords (String text) {
        String[] words = text.split(" ");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));

        HashMap<String, Integer> sameWords = sameWords(wordsList);

        TreeMap<Integer, ArrayList<String>> orderedInversion =
                new TreeMap<Integer, ArrayList<String>>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(o2, o1);
                    }
                });

        for (Map.Entry entry : sameWords.entrySet()) {
            if (orderedInversion.containsKey(entry.getValue())) {
                orderedInversion.get((Integer)entry.getValue()).add((String)entry.getKey());
            }
            else {
                ArrayList<String> newIndex = new ArrayList<>();
                newIndex.add((String) entry.getKey());
                orderedInversion.put((Integer)entry.getValue(), newIndex);
            }
        }

        int count = 0;
        String[] arrResult = new String[10];
        ArrayList<String> entryArr = new ArrayList<>();

        for (Map.Entry entry : orderedInversion.entrySet()) {

            entryArr = (ArrayList<String>) entry.getValue();
            for (String s : entryArr) {
                arrResult[count] = s;
                count++;
                if (count > 9) break;
            }
            if (count > 9) break;
        }

        return Arrays.toString(arrResult);
    }
}


