package com.ifmo.jjd.practice26.tenwords;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        countTopTenByEachProc(text, Runtime.getRuntime().availableProcessors());

    }


    public static void countTopTenByEachProc(String text, int procCount) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));

        ArrayList<TenwordsThread> threads = new ArrayList<>();

        for (int i = 0; i < procCount; i++) {

            if (i == procCount - 1) {
                threads.add(new TenwordsThread(words.subList(i * words.size() / procCount, words.size())));
                break;
            }
            threads.add(new TenwordsThread(words.subList(i * words.size() / procCount, (i + 1) * words.size() / procCount)));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread->{
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("******");

        //todo обязательно доделать!!!
        Stream stream = threads.get(0).getSameWords()
                .entrySet()
                .stream();
        /*for (int i = 1; i < threads.size(); i++) {
            stream = Stream.concat(stream, threads.get(i).getSameWords()
                    .entrySet()
                    .stream())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            Integer::sum
                    ));
        }*/


        threads.get(0).getSameWords()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum));


//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        Integer::sum)
//                );
    }

}



