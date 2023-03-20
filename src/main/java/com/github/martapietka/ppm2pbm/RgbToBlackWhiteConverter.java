package com.github.martapietka.ppm2pbm;

public class RgbToBlackWhiteConverter {

    public static int convertRgbToBlackWhite(int r, int g, int b) {

        int[] rgbArray = {r, g, b};
        int v = rgbArray[0];

        for(int i=0; i<rgbArray.length; i++) {
            if (rgbArray[i] > v) {
                v = rgbArray[i];
            }
        }

        if (v >= 128) {
            return 0;
        } else {
            return 1;
        }

    }
}
