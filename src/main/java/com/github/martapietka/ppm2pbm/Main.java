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
                if (args[3].equals("average")) {
                    PpmToPgmConverter ppmToPgmConverter = new PpmToPgmConverter(new RgbToGrayscaleByAverageConverter());
                    ppmToPgmConverter.convert(inputStream, outputStream);
                } else if (args[3].equals("max")) {
                    PpmToPgmConverter ppmToPgmConverter = new PpmToPgmConverter(new RgbToGrayscaleByMaxConverter());
                    ppmToPgmConverter.convert(inputStream, outputStream);
                } else if (args[3].equals("weight")) {
                    PpmToPgmConverter ppmToPgmConverter = new PpmToPgmConverter(new RgbToGrayscaleByWeightConverter());
                    ppmToPgmConverter.convert(inputStream, outputStream);
                }
            } else if (args[2].equals("pbm")) {
                if (args[3].equals("average")) {
                    PpmToPbmConverter ppmToPbmConverter = new PpmToPbmConverter(Integer.parseInt(args[4]), new RgbToGrayscaleByAverageConverter());
                    ppmToPbmConverter.convert(inputStream, outputStream);
                } else if (args[3].equals("max")) {
                    PpmToPbmConverter ppmToPbmConverter = new PpmToPbmConverter(Integer.parseInt(args[4]), new RgbToGrayscaleByMaxConverter());
                    ppmToPbmConverter.convert(inputStream, outputStream);
                } else if (args[3].equals("weight")) {
                    PpmToPbmConverter ppmToPbmConverter = new PpmToPbmConverter(Integer.parseInt(args[4]), new RgbToGrayscaleByWeightConverter());
                    ppmToPbmConverter.convert(inputStream, outputStream);
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}