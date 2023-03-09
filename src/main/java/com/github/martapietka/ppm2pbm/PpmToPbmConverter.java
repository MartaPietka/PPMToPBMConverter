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

        byte[] newHeader = {header[0], 0x31, header[2]};

        int width = ByteReader.convertBytesToInt(inputStream);
        int height = ByteReader.convertBytesToInt(inputStream);

        String newWidth = Integer.toString(width);
        newWidth.getBytes(StandardCharsets.UTF_8);

        String newHeight = Integer.toString(height);
        newHeight.getBytes(StandardCharsets.UTF_8);

        PrintStream printStream = new PrintStream(outputStream);

        printStream.write(newHeader);
        printStream.write(newWidth.getBytes());
        printStream.write(" ".getBytes());
        printStream.write(newHeight.getBytes());
    }
}
