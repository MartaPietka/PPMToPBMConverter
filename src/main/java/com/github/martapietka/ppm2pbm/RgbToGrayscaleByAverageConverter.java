package com.github.martapietka.ppm2pbm;

import java.util.stream.IntStream;

public class RgbToGrayscaleByAverageConverter {

    public static int convertRgbToGrayscale(int r, int g, int b) {

        return (r + g + b) / 3;

    }
}
