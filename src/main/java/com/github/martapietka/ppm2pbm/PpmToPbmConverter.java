package com.github.martapietka.ppm2pbm;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PpmToPbmConverter extends PpmConverter {

    @Override
    public void printHeader(OutputStream outputStream) throws IOException {

        byte[] p1Header = {0x50, 0x31, 0xA};
        outputStream.write(p1Header);
    }

    @Override
    public void printColourDepth(InputStream inputStream, OutputStream outputStream) throws IOException {

        int colourDepth = ByteReader.convertBytesToInt(inputStream);
        String grayscaleString = Integer.toString(255);
        byte[] grayscaleBytes = grayscaleString.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void printOutput(InputStream inputStream, OutputStream outputStream) throws IOException {

        byte[] rgbArray;
        int counter = 1;

        while ((rgbArray = inputStream.readNBytes(3)).length > 0) {
            int r = Byte.toUnsignedInt(rgbArray[0]);
            int g = Byte.toUnsignedInt(rgbArray[1]);
            int b = Byte.toUnsignedInt(rgbArray[2]);
            int blackWhite = RgbToBlackWhiteConverter.convertRgbToBlackWhite(r, g, b);
            outputStream.write(blackWhite + 48);

            if (counter % 3 == 0) {
                outputStream.write(0xA);
            } else {
                outputStream.write(0x20);
            }
            counter++;
        }
        outputStream.flush();
    }
}
