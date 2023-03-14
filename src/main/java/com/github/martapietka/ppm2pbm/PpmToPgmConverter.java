package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PpmToPgmConverter {

    public static void convert(InputStream inputStream, OutputStream outputStream) throws IOException {

        byte[] header = inputStream.readNBytes(3);

        if (!((header[0] == 0x50) && (header[1] == 0x36) && (header[2] <= 0x1F))) {
            System.err.println("Invalid file format");
            System.exit(1);
        }

        int commentStart = inputStream.read();
        if (commentStart != 0x23) {
            System.err.println("Missing comment");
            System.exit(1);
        }

        while (inputStream.read() > 0x1F) {
            // skip comment
        }

        byte[] p5Header = {0x50, 0x35, 0xA};

        int width = ByteReader.convertBytesToInt(inputStream);
        int height = ByteReader.convertBytesToInt(inputStream);
        int colourDepth = ByteReader.convertBytesToInt(inputStream);

        String widthString = Integer.toString(width);
        byte[] widthBytes = widthString.getBytes(StandardCharsets.UTF_8);

        String heightString = Integer.toString(height);
        byte[] heightBytes = heightString.getBytes(StandardCharsets.UTF_8);

        String grayscaleString = Integer.toString(255);
        byte[] grayscaleBytes = grayscaleString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(p5Header);
        outputStream.write(widthBytes);
        outputStream.write(0x20);
        outputStream.write(heightBytes);
        outputStream.write(0xA);
        outputStream.write(grayscaleBytes);
        outputStream.write(0xA);

        byte[] rgbArray;
        while ((rgbArray = inputStream.readNBytes(3)).length > 0) {
            int r = Byte.toUnsignedInt(rgbArray[0]);
            int g = Byte.toUnsignedInt(rgbArray[1]);
            int b = Byte.toUnsignedInt(rgbArray[2]);
            int grayscale = RgbToGrayscaleByWeightConverter.convertRgbToGrayscale(r, g, b);
            outputStream.write(grayscale);
        }
        outputStream.flush();
    }
}
