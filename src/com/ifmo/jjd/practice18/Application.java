package com.ifmo.jjd.practice18;

import java.io.*;

public class Application {
    public static void main(String[] args) {

        /*Написать декораторы, наследующиеся от FilterOutputStream и FilterInputStream,
        шифрующие и дешифрующие исходящие и входящие байты XOR-шифрованием. ^

                программа -> decorator(outputStream) -> outputStream
                программа <- decorator(inputStream) <- inputStream*/

        String filename = "D:/Irene/Irene/_My/Java/ITMO/practices/src/com/ifmo/jjd/practice18/test.txt";
        String pKey = "!@#$%^&&&%";
        StringBuilder sb = new StringBuilder();
        byte[] encrypted;

        try (FileInputStream file = new FileInputStream(filename); XORInputStream xorInput = new XORInputStream(file))
        {
            int i = -1;
            while((i = file.read()) != -1){
                sb = sb.append((char) i);
            }

            String text = sb.toString();

            encrypted = xorInput.encode(text, pKey);

            String decode = XOROutputStream.decode(encrypted, pKey);

            System.out.println("byte: " + encrypted);
            System.out.println("decode: " + decode);


        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }



    }
}
