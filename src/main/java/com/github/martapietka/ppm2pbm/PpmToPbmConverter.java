package com.github.martapietka.ppm2pbm;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PpmToPbmConverter {

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

        byte[] p1Header = {0x50, 0x31, 0x20, 0xA};

        int width = ByteReader.convertBytesToInt(inputStream);
        int height = ByteReader.convertBytesToInt(inputStream);

        String widthString = Integer.toString(width);
        byte[] widthBytes = widthString.getBytes(StandardCharsets.UTF_8);

        String heightString = Integer.toString(height);
        byte[] heightBytes = heightString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(p1Header);
        outputStream.write(widthBytes);
        outputStream.write(0x20);
        outputStream.write(heightBytes);
    }
}
