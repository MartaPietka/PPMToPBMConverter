package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PpmToPgmConverter extends PpmConverter {

    private final RgbToGrayscaleConverter rgbToGrayscaleConverter;

    public PpmToPgmConverter(RgbToGrayscaleConverter rgbToGrayscaleConverter) {
        this.rgbToGrayscaleConverter = rgbToGrayscaleConverter;
    }

    @Override
    public void printHeader (OutputStream outputStream) throws IOException {
        byte[] p5Header = {0x50, 0x35, 0xA};
        outputStream.write(p5Header);
    }

    @Override
    public void printOutput(InputStream inputStream, OutputStream outputStream, Header header) throws IOException {

        String colourDepthString = Integer.toString(255);
        byte[] colourDepthBytes = colourDepthString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(colourDepthBytes);
        outputStream.write(0xA);

        byte[] rgbArray;
        while ((rgbArray = inputStream.readNBytes(3)).length > 0) {
            int r = Byte.toUnsignedInt(rgbArray[0]);
            int g = Byte.toUnsignedInt(rgbArray[1]);
            int b = Byte.toUnsignedInt(rgbArray[2]);

            outputStream.write(rgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b));
        }
        outputStream.flush();
    }
}
