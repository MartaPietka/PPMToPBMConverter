package com.github.martapietka.ppm2pbm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of(args[0]);

        try (InputStream inputStream = Files.newInputStream(path);
        OutputStream outputStream = Files.newOutputStream(Path.of("/Users/martapietka/output.pgm"))) {
            PpmToPgmConverter.convert(inputStream, outputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}