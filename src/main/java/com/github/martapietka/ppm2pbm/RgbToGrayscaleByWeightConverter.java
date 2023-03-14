package com.github.martapietka.ppm2pbm;

import java.util.stream.IntStream;

public class RgbToGrayscaleByWeightConverter {

    public static int convertRgbToGrayscale(double r, double g, double b) {

//        double sum = 0.299*r + 0.587*g + 0.114*b;
//        int v = (int) Math.round(sum);

        return (int) Math.round(0.299*r + 0.587*g + 0.114*b);

    }
}