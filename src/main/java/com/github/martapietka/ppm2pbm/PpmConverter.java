package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public abstract class PpmConverter {

    public final void convert(InputStream inputStream, OutputStream outputStream) throws IOException {

        Header header = readHeader(inputStream);
        printHeader(outputStream);
        printWidthAndHeight(outputStream, header);
        printOutput(inputStream, outputStream, header);

    }

    private Header readHeader(InputStream inputStream) throws IOException {

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

    protected abstract void printHeader(OutputStream outputStream) throws IOException;

    protected void printWidthAndHeight(OutputStream outputStream, Header header) throws IOException {

        int width = header.width();
        String widthString = Integer.toString(width);
        byte[] widthBytes = widthString.getBytes(StandardCharsets.UTF_8);

        int height = header.height();
        String heightString = Integer.toString(height);
        byte[] heightBytes = heightString.getBytes(StandardCharsets.UTF_8);

        outputStream.write(widthBytes);
        outputStream.write(0x20);
        outputStream.write(heightBytes);
        outputStream.write(0xA);
    }

    private void printOutput(InputStream inputStream, OutputStream outputStream, Header header) throws IOException {

        byte[] rgbArray;

        while ((rgbArray = inputStream.readNBytes(3)).length > 0) {
            int r = Byte.toUnsignedInt(rgbArray[0]);
            int g = Byte.toUnsignedInt(rgbArray[1]);
            int b = Byte.toUnsignedInt(rgbArray[2]);

            byte[] bytes = convertRgbToBytes(r, g, b);
            outputStream.write(bytes);
        }
        outputStream.flush();
    }

    protected abstract byte[] convertRgbToBytes (int r, int g, int b);

}
