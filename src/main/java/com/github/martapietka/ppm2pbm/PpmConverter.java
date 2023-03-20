package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public abstract class PpmConverter {

    public final void convert(InputStream inputStream, OutputStream outputStream) throws IOException {

        readBytes(inputStream);
        printHeader(outputStream);
        printWidthAndHeight(inputStream, outputStream);
        printColourDepth(inputStream, outputStream);
        printOutput(inputStream, outputStream);

    }

    public final void readBytes(InputStream inputStream) throws IOException {
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

    public abstract void printHeader(OutputStream outputStream) throws IOException;

    public final void printWidthAndHeight(InputStream inputStream, OutputStream outputStream) throws IOException {
        int width = ByteReader.convertBytesToInt(inputStream);
        int height = ByteReader.convertBytesToInt(inputStream);

        String widthString = Integer.toString(width);
        byte[] widthBytes = widthString.getBytes(StandardCharsets.UTF_8);

        String heightString = Integer.toString(height);
        byte[] heightBytes = heightString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(widthBytes);
        outputStream.write(0x20);
        outputStream.write(heightBytes);
        outputStream.write(0xA);
    }

    public void printColourDepth(InputStream inputStream, OutputStream outputStream) throws IOException {
    }

    public void printOutput(InputStream inputStream, OutputStream outputStream) throws IOException {

    }

}
