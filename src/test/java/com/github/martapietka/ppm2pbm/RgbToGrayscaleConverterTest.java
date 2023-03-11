package com.github.martapietka.ppm2pbm;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RgbToGrayscaleConverterTest {
    @Test
    void convertRgbToGreen() {

        int expectedResult = 235;

        // WHEN
        int r = 102;
        int g = 235;
        int b = 125;

        int result = RgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void convertRgbToWhite() {

        int expectedResult = 255;

        // WHEN
        int r = 255;
        int g = 255;
        int b = 255;

        int result = RgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void convertRgbToBlack() {

        int expectedResult = 0;

        // WHEN
        int r = 0;
        int g = 0;
        int b = 0;

        int result = RgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void convertRgbToGray() {

        int expectedResult = 128;

        // WHEN
        int r = 128;
        int g = 128;
        int b = 128;

        int result = RgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void convertRgbToBrown() {

        int expectedResult = 115;

        // WHEN
        int r = 115;
        int g = 40;
        int b = 60;

        int result = RgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }
}