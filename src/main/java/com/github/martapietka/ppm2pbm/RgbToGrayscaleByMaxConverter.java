package com.github.martapietka.ppm2pbm;

import java.util.stream.IntStream;

public class RgbToGrayscaleByMaxConverter {

    public static int convertRgbToGrayscale(int r, int g, int b) {

        return IntStream.of(r, g, b)
                .max()
                .orElse(0);

    }
}
