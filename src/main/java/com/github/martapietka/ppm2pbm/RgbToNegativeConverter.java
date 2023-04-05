package com.github.martapietka.ppm2pbm;

public class RgbToNegativeConverter {

    public byte[] convertRgbToNegative (int r, int g, int b) {

        int newR = 255 - r;
        int newG = 255 - g;
        int newB = 255 - b;

        return new byte[]{(byte) newR, (byte) newG, (byte) newB};
    }
}
