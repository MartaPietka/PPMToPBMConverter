package com.github.martapietka.ppm2pbm;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PpmToPbmConverter extends PpmConverter {

    private final int threshold;
    private final RgbToGrayscaleConverter rgbToGrayscaleConverter;

    public PpmToPbmConverter(int threshold, RgbToGrayscaleConverter rgbToGrayscaleConverter) {
        this.threshold = threshold;
        this.rgbToGrayscaleConverter = rgbToGrayscaleConverter;
    }


    @Override
    public void printOutput(InputStream inputStream, OutputStream outputStream, Header header) throws IOException {

        byte[] p1Header = {0x50, 0x31, 0xA};

        int width = header.width();
        String widthString = Integer.toString(width);
        byte[] widthBytes = widthString.getBytes(StandardCharsets.UTF_8);

        int height = header.height();
        String heightString = Integer.toString(height);
        byte[] heightBytes = heightString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(p1Header);
        outputStream.write(widthBytes);
        outputStream.write(0x20);
        outputStream.write(heightBytes);
        outputStream.write(0xA);

        byte[] rgbArray;
        int counter = 1;

        while ((rgbArray = inputStream.readNBytes(3)).length > 0) {
            int r = Byte.toUnsignedInt(rgbArray[0]);
            int g = Byte.toUnsignedInt(rgbArray[1]);
            int b = Byte.toUnsignedInt(rgbArray[2]);
            int blackWhite = RgbToBlackWhiteConverter.convertRgbToBlackWhite(rgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b), threshold);
            outputStream.write(blackWhite + 48);

            if (counter % width == 0) {
                outputStream.write(0xA);
            } else {
                outputStream.write(0x20);
            }
            counter++;
        }
        outputStream.flush();
    }
}
