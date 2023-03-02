package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;

public class ByteReader {

    public static int convertBytesToInt(InputStream inputStream) throws IOException {

        byte[] array = inputStream.readAllBytes();

        StringBuilder sb = new StringBuilder();

        for (int a=0; a < array.length; a++) {
            if (array[a] <= 0x1F) {
                break;
            }
            int digit = array[a] - 48;
            sb.append(digit);
        }

        inputStream.close();
        return Integer.valueOf(sb.toString());
    }
}


