package com.ifmo.jjd.practice18;

import java.io.FilterInputStream;
import java.io.InputStream;

public class XORInputStream extends FilterInputStream {

    public XORInputStream(InputStream in) {
        super(in);
    }

    public byte[] encode(String pText, String pKey) {
        byte[] txt = pText.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[pText.length()];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }

        return res;
    }
}
