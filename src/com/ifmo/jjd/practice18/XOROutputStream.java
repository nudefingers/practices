package com.ifmo.jjd.practice18;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class XOROutputStream extends FilterOutputStream {

    public XOROutputStream(OutputStream out) {
        super(out);
    }

    public static String decode(byte[] pText, String pKey) {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return new String(res);
    }
}
