package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PpmToPgmConverter extends PpmConverter {

    private final RgbToGrayscaleConverter rgbToGrayscaleConverter;

    public PpmToPgmConverter(RgbToGrayscaleConverter rgbToGrayscaleConverter) {
        this.rgbToGrayscaleConverter = rgbToGrayscaleConverter;
    }

    @Override
    protected byte[] pHeader() {
        return new byte[]{0x50, 0x35, 0xA};
    }

    @Override
    protected void printHeader(OutputStream outputStream, Header header) throws IOException {

        super.printHeader(outputStream, header);

        String colourDepthString = Integer.toString(255);
        byte[] colourDepthBytes = colourDepthString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(colourDepthBytes);
        outputStream.write(0xA);
    }

    @Override
    protected byte[] convertRgbToBytes(int r, int g, int b) {

        int grayscaleValue = rgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        return new byte[]{(byte) grayscaleValue};
    }
}