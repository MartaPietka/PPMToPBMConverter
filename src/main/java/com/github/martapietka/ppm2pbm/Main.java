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

            if (args[2].equals("pgm") && args[3].equals("average")) {
                PpmToPgmConverter ppmToPgmConverter = new PpmToPgmConverter(new RgbToGrayscaleByAverageConverter());
                ppmToPgmConverter.convert(inputStream, outputStream);
            } else if (args[2].equals("pgm") && args[3].equals("max")) {
                PpmToPgmConverter ppmToPgmConverter = new PpmToPgmConverter(new RgbToGrayscaleByMaxConverter());
                ppmToPgmConverter.convert(inputStream, outputStream);
            } else if (args[2].equals("pgm") && args[3].equals("weight")) {
                PpmToPgmConverter ppmToPgmConverter = new PpmToPgmConverter(new RgbToGrayscaleByWeightConverter());
                ppmToPgmConverter.convert(inputStream, outputStream);
            }

//            PpmToPbmConverter sepiaBlackWhite = new PpmToPbmConverter();
//            sepiaBlackWhite.convert(inputStream, outputStream);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}