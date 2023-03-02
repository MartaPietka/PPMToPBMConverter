package com.github.martapietka.ppm2pbm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of(args[0]);

        try (InputStream inputStream = Files.newInputStream(path)) {
            PpmToPbmConverter.convert(inputStream, System.out);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}