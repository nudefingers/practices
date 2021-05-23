package com.ifmo.jjd.practice26.tenwords;

import java.util.*;

public class TenwordsThread extends Thread{
    private List<String> words;
    private HashMap<String, Integer> sameWords;

    public TenwordsThread(List<String> words) {
        setWords(words);
        sameWords = new HashMap<>();
    }

    public List<String> getWords() {
        return words;
    }

    public HashMap<String, Integer> getSameWords() {
        return sameWords;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    @Override
    public void run() {
        tenWords(words);

        /*sameWords.forEach((key, value) -> {
            System.out.println(Thread.currentThread().getName() +  ":: word - " + key + ", count - " + value);
        });*/
    }

    public void tenWords (List<String> wordsList) {

        HashMap<String, Integer> sameWords = new HashMap<>();
        for (String word : wordsList) {
            sameWords.put(word, sameWords.getOrDefault(word, 0) + 1 );
        }

        this.sameWords = sameWords;

        // этот метод заканчивается
        //дальше собираем все sameWords из потоков в одну

        /*TreeMap<Integer, ArrayList<String>> orderedInversion =
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

        return Arrays.toString(arrResult);*/
    }
}
