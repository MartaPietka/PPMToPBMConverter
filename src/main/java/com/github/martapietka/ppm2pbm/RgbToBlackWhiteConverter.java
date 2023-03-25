package com.github.martapietka.ppm2pbm;

public class RgbToBlackWhiteConverter {

    public static int convertRgbToBlackWhite(int rgbToGrayscaleConverter, int threshold) {

        if (rgbToGrayscaleConverter >= threshold) {
            return 0;
        } else {
            return 1;
        }

    }
}
