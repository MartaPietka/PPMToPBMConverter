package com.github.martapietka.ppm2pbm;

public class RgbToBlackWhiteConverter {

    public static BlackOrWhite convertRgbToBlackWhite(int rgbToGrayscaleConverter, int threshold) {

        if (rgbToGrayscaleConverter >= threshold) {
            return BlackOrWhite.WHITE;
        } else {
            return BlackOrWhite.BLACK;
        }
    }
}
