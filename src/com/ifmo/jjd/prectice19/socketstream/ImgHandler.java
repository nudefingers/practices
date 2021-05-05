package com.ifmo.jjd.prectice19.socketstream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ImgHandler extends FileHandler{
    public ImgHandler(File file) {
        setFile(file);
    }

    public ImgHandler() {}

    public void setFile(File file) {
        this.file = file;
    }

    private String getExtension() {
        return Optional.of(file.getName())
                .filter(s -> s.contains("."))
                .map(s -> s.substring(file.getName().lastIndexOf(".") + 1))
                .orElse("png");
    }

    @Override
    public boolean writeToFile(byte[] data) throws IOException {
        try (ByteArrayInputStream stream = new ByteArrayInputStream(data)){
            BufferedImage bufferedImage = ImageIO.read(stream);
            return ImageIO.write(bufferedImage, "png", file);
        }

    }

    @Override
    public byte[] readFromFile() throws IOException {
        // import java.awt.image.BufferedImage;
        // import javax.imageio.ImageIO;
        BufferedImage bufferedImage = ImageIO.read(file);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", stream);

        return stream.toByteArray();
    }
}
