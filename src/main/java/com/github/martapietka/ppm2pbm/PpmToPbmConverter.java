package com.github.martapietka.ppm2pbm;

import java.io.*;

public class PpmToPbmConverter extends PpmConverter {

    private final int threshold;
    private final RgbToGrayscaleConverter rgbToGrayscaleConverter;

    public PpmToPbmConverter(int threshold, RgbToGrayscaleConverter rgbToGrayscaleConverter) {
        this.threshold = threshold;
        this.rgbToGrayscaleConverter = rgbToGrayscaleConverter;
    }

    @Override
    public void printHeader (OutputStream outputStream) throws IOException {
        byte[] p1Header = {0x50, 0x31, 0xA};
        outputStream.write(p1Header);
    }

    @Override
    public void printOutput(InputStream inputStream, OutputStream outputStream, Header header) throws IOException {

        byte[] rgbArray;
        int counter = 1;

        while ((rgbArray = inputStream.readNBytes(3)).length > 0) {
            int r = Byte.toUnsignedInt(rgbArray[0]);
            int g = Byte.toUnsignedInt(rgbArray[1]);
            int b = Byte.toUnsignedInt(rgbArray[2]);

            BlackOrWhite blackWhite = RgbToBlackWhiteConverter.convertRgbToBlackWhite(rgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b), threshold);
            if (blackWhite == BlackOrWhite.WHITE) {
                outputStream.write(0x30);
            } else if (blackWhite == BlackOrWhite.BLACK) {
                outputStream.write(0x31);
            }

            if (counter % header.width() == 0) {
                outputStream.write(0xA);
            } else {
                outputStream.write(0x20);
            }
            counter++;
        }
        outputStream.flush();
    }
}
