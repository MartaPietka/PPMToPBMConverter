package com.github.martapietka.ppm2pbm;

public class RgbToGrayscaleByWeightConverter implements RgbToGrayscaleConverter {

    @Override
    public int convertRgbToGrayscale(int r, int g, int b) {

        return (int) Math.round(0.299*r + 0.587*g + 0.114*b);

    }
}