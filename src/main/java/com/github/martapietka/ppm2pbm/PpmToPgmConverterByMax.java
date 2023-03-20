package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PpmToPgmConverterByMax extends PpmToPgmConverter {

    @Override
    public void printOutput(InputStream inputStream, OutputStream outputStream) throws IOException {

        byte[] rgbArray;
        while ((rgbArray = inputStream.readNBytes(3)).length > 0) {
            int r = Byte.toUnsignedInt(rgbArray[0]);
            int g = Byte.toUnsignedInt(rgbArray[1]);
            int b = Byte.toUnsignedInt(rgbArray[2]);
            PpmConverterStrategy grayscale = new PpmConverterStrategy(new RgbToGrayscaleByMaxConverter());
            outputStream.write(grayscale.convertRgbToGrayscale(r, g, b));
        }
        outputStream.flush();
    }
}
