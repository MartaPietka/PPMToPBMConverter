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

            if (args[2].equals("pgm")) {

                PpmToPgmConverter ppmToPgmConverter;

                if (args[3].equals("average")) {
                    ppmToPgmConverter = new PpmToPgmConverter(getRgbToGrayscaleByAverageConverter());
                } else if (args[3].equals("max")) {
                    ppmToPgmConverter = new PpmToPgmConverter(getRgbToGrayscaleByMaxConverter());
                } else {
                    ppmToPgmConverter = new PpmToPgmConverter(getRgbToGrayscaleByWeightConverter());
                }

                ppmToPgmConverter.convert(inputStream, outputStream);

            } else if (args[2].equals("pbm")) {

                PpmToPbmConverter ppmToPbmConverter;

                if (args[3].equals("average")) {
                    ppmToPbmConverter = new PpmToPbmConverter(Integer.parseInt(args[4]), getRgbToGrayscaleByAverageConverter());
                } else if (args[3].equals("max")) {
                    ppmToPbmConverter = new PpmToPbmConverter(Integer.parseInt(args[4]), getRgbToGrayscaleByMaxConverter());
                } else {
                    ppmToPbmConverter = new PpmToPbmConverter(Integer.parseInt(args[4]), getRgbToGrayscaleByWeightConverter());
                }

                ppmToPbmConverter.convert(inputStream, outputStream);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static RgbToGrayscaleByAverageConverter getRgbToGrayscaleByAverageConverter() {
        return new RgbToGrayscaleByAverageConverter();
    }

    private static RgbToGrayscaleByMaxConverter getRgbToGrayscaleByMaxConverter() {
        return new RgbToGrayscaleByMaxConverter();
    }

    private static RgbToGrayscaleByWeightConverter getRgbToGrayscaleByWeightConverter() {
        return new RgbToGrayscaleByWeightConverter();
    }

}