package com.github.martapietka.ppm2pbm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        RgbToGrayscaleConverter rgbToGrayscaleConverter = switch (args[3]) {
            case "average" -> new RgbToGrayscaleByAverageConverter();
            case "max" -> new RgbToGrayscaleByMaxConverter();
            default -> new RgbToGrayscaleByWeightConverter();
        };

        PpmConverter ppmConverter = switch (args[2]) {
            case "pgm" -> new PpmToPgmConverter(rgbToGrayscaleConverter);
            case "pbm" -> new PpmToPbmConverter(Integer.parseInt(args[4]), rgbToGrayscaleConverter);
            default -> null;
        };

        try (InputStream inputStream = Files.newInputStream(inputPath);
             OutputStream outputStream = Files.newOutputStream(outputPath)) {

            ppmConverter.convert(inputStream, outputStream);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}