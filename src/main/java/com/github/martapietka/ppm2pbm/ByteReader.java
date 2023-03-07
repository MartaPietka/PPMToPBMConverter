package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;

public class ByteReader {

    public static int convertBytesToInt(InputStream inputStream) throws IOException {

        StringBuilder sb = new StringBuilder();

        int byteValue;
        while ((byteValue = inputStream.read()) > 0x20) {
            int digit = byteValue - 48;
            sb.append(digit);
        }

        return Integer.parseInt(sb.toString());
    }
}


