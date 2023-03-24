package com.github.martapietka.ppm2pbm;

public class RgbToBlackWhiteConverter {

    private final int threshold;
    private final int rgbToGrayscaleConverter;

    public RgbToBlackWhiteConverter(int threshold, int rgbToGrayscaleConverter) {
        this.threshold = threshold;
        this.rgbToGrayscaleConverter = rgbToGrayscaleConverter;
    }

    public int getThreshold() {
        return threshold;
    }

    public static int convertRgbToBlackWhite(int rgbToGrayscaleConverter, int threshold) {

        if (rgbToGrayscaleConverter >= threshold) {
            return 0;
        } else {
            return 1;
        }

    }
}
