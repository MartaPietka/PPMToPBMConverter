package com.github.martapietka.ppm2pbm;

public class RgbToBlackWhiteConverter {

    private int threshold;

    public RgbToBlackWhiteConverter(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }

    public static int convertRgbToBlackWhite(int r, int g, int b, int threshold) {

        int[] rgbArray = {r, g, b};
        int v = rgbArray[0];

        for(int i=0; i<rgbArray.length; i++) {
            if (rgbArray[i] > v) {
                v = rgbArray[i];
            }
        }

        if (v >= threshold) {
            return 0;
        } else {
            return 1;
        }

    }
}
