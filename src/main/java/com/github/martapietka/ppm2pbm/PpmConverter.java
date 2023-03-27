package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class PpmConverter {

    public final void convert(InputStream inputStream, OutputStream outputStream) throws IOException {

        Header header = readHeader(inputStream);
        printOutput(inputStream, outputStream, header);

    }

    public Header readHeader(InputStream inputStream) throws IOException {

        byte[] headerP = inputStream.readNBytes(3);

        if (!((headerP[0] == 0x50) && (headerP[1] == 0x36) && (headerP[2] <= 0x1F))) {
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

        int width = ByteReader.convertBytesToInt(inputStream);
        int height = ByteReader.convertBytesToInt(inputStream);
        int colourDepth = ByteReader.convertBytesToInt(inputStream);

        return new Header(width, height, colourDepth);

    }

    public abstract void printOutput(InputStream inputStream, OutputStream outputStream, Header header) throws IOException;

}
