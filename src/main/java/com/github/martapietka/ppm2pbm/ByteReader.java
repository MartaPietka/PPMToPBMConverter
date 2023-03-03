package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;

public class ByteReader {

    public static int convertBytesToInt(InputStream inputStream) throws IOException {

        StringBuilder sb = new StringBuilder();

        int number;
        while ((number = inputStream.read()) != -1) {
            if (number <= 0x1F) {
                break;
            }
            number -= 48;
            sb.append(number);
        }

        return Integer.parseInt(sb.toString());
    }
}


