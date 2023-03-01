package com.github.martapietka.ppm2pbm;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class PpmToPbmConverter {

    public static void convert(InputStream inputStream, OutputStream outputStream) {

        byte[] array = Files.readAllBytes(path);

        if (!((array[0] == 0x50) && (array[1] == 0x36))) {
            System.err.println("Invalid file format");
            System.exit(1);
        }

        int i = 2;
        do {
            array[i] = 0;
            i++;
        } while (i <= (array.length - 1) && array[i] != 10);

        ArrayList<Byte> list = new ArrayList<>();
        for (byte b : array) {
            if (b <= (array.length - 1) && b != 0) {
                list.add(b);
            }
        }
        list.remove(2);
        System.out.println(list);

        if ((list.get(2) <= 0) || (list.get(4) <= 0) || (list.get(6) != 50) || (list.get(7) != 53) || (list.get(8) != 53)) {
            System.err.println("Invalid file size");
            System.exit(1);
        }

//            for (byte a : array) {
//                System.out.println(a);
//            }

//            Bytes to Unsigned Byte
//            for (byte a : array) {
//                System.out.println(Byte.toUnsignedInt(a));
//            }

    }
}
