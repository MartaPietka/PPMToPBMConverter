package com.github.martapietka.ppm2pbm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        try (InputStream inputStream = Files.newInputStream(inputPath);
        OutputStream outputStream = Files.newOutputStream(outputPath)) {

//            PpmToPgmConverterByAverage sepiaAverage = new PpmToPgmConverterByAverage();
//            sepiaAverage.convert(inputStream, outputStream);

//            PpmToPgmConverterByMax sepiaMax = new PpmToPgmConverterByMax();
//            sepiaMax.convert(inputStream, outputStream);

//            PpmToPgmConverterByWeight sepiaWeight = new PpmToPgmConverterByWeight();
//            sepiaWeight.convert(inputStream, outputStream);

//            PpmToPbmConverter sepiaBlackWhite = new PpmToPbmConverter();
//            sepiaBlackWhite.convert(inputStream, outputStream);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}