package com.github.martapietka.ppm2pbm;

import java.io.*;

public class PpmToPbmConverter extends PpmConverter {

    private final int threshold;
    private final RgbToGrayscaleConverter rgbToGrayscaleConverter;
    private Header header;
    private int counter = 1;

    public PpmToPbmConverter(int threshold, RgbToGrayscaleConverter rgbToGrayscaleConverter) {
        this.threshold = threshold;
        this.rgbToGrayscaleConverter = rgbToGrayscaleConverter;
    }

    @Override
    protected byte[] pHeader() {
        return new byte[]{0x50, 0x31, 0xA};
    }

    @Override
    protected void printHeader(OutputStream outputStream, Header header) throws IOException {
        super.printHeader(outputStream, header);
        this.header = header;
    }

    @Override
    protected byte[] convertRgbToBytes(int r, int g, int b) {

        BlackOrWhite blackWhite = RgbToBlackWhiteConverter.convertRgbToBlackWhite(rgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b), threshold);

        byte byteValue = switch (blackWhite) {
            case WHITE -> 0x30;
            case BLACK -> 0x31;
        };

        byte separatorValue = (byte) ((counter++ % header.width() == 0) ? 0xA : 0x20);
        return new byte[]{byteValue, separatorValue};
    }
}
