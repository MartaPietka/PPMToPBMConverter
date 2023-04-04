package com.github.martapietka.ppm2pbm;

public interface RgbToGrayscaleConverter {

    /**
     * Converts rgb colour to grayscale.
     * @param r red component in 0-255 range
     * @param g green component in 0-255 range
     * @param b blue component in 0-255 range
     * @return grayscale in 0-255 range
     */
    int convertRgbToGrayscale(int r, int g, int b);

}
