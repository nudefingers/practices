package com.ifmo.jjd.prectice19.socketstream;

import java.io.File;
import java.io.IOException;

public abstract class FileHandler {
    protected File file;

    abstract public boolean writeToFile(byte[] data) throws IOException;
    abstract public byte[] readFromFile() throws IOException;
}
