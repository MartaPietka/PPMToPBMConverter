package com.github.martapietka.ppm2pbm;

import java.io.IOException;
import java.io.InputStream;

public class ByteReader {

    public static int convertBytesToInt(InputStream inputStream) throws IOException {

        byte[] array = inputStream.readAllBytes();

        StringBuilder sb = new StringBuilder();
        int a = 0;
        while (a < array.length) {
            switch (array[a]) {
                case 48:
                    sb.append(0);
                    break;
                case 49:
                    sb.append(1);
                    break;
                case 50:
                    sb.append(2);
                    break;
                case 51:
                    sb.append(3);
                    break;
                case 52:
                    sb.append(4);
                    break;
                case 53:
                    sb.append(5);
                    break;
                case 54:
                    sb.append(6);
                    break;
                case 55:
                    sb.append(7);
                    break;
                case 56:
                    sb.append(8);
                    break;
                case 57:
                    sb.append(9);
                    break;
            }
            a++;
        }

        return Integer.valueOf(String.valueOf(sb));
    }
}


