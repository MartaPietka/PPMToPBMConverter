package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PpmToPpmConverter extends PpmConverter {

    RgbToNegativeConverter rgbToNegativeConverter = new RgbToNegativeConverter();

    @Override
    protected void printHeader(OutputStream outputStream) throws IOException {
        byte[] p6Header = {0x50, 0x36, 0xA};
        outputStream.write(p6Header);
    }

    @Override
    protected void printWidthAndHeight(OutputStream outputStream, Header header) throws IOException {

        super.printWidthAndHeight(outputStream, header);

        String colourDepthString = Integer.toString(255);
        byte[] colourDepthBytes = colourDepthString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(colourDepthBytes);
        outputStream.write(0xA);
    }

    @Override
    protected byte[] convertRgbToBytes(int r, int g, int b) {

        return rgbToNegativeConverter.convertRgbToNegative(r, g, b);
    }
}
