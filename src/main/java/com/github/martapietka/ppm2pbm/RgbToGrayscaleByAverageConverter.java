package com.github.martapietka.ppm2pbm;

public class RgbToGrayscaleByAverageConverter implements RgbToGrayscaleConverter {

    @Override
    public int convertRgbToGrayscale(int r, int g, int b) {

        return (r + g + b) / 3;

    }
}
