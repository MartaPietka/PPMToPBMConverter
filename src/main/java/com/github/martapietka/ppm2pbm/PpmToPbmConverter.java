package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
    }
}
