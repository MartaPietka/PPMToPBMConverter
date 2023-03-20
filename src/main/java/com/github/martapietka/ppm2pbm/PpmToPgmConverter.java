package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PpmToPgmConverter extends PpmConverter {

    @Override
    public void printHeader(OutputStream outputStream) throws IOException {

        byte[] p5Header = {0x50, 0x35, 0xA};
        outputStream.write(p5Header);
    }

    @Override
    public void printColourDepth(InputStream inputStream, OutputStream outputStream) throws IOException {

        int colourDepth = ByteReader.convertBytesToInt(inputStream);
        String grayscaleString = Integer.toString(255);
        byte[] grayscaleBytes = grayscaleString.getBytes(StandardCharsets.UTF_8);
        outputStream.write(grayscaleBytes);
        outputStream.write(0xA);
    }
}
