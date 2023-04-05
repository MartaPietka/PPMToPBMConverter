package com.github.martapietka.ppm2pbm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RgbToNegativeConverterTest {

    private RgbToNegativeConverter rgbToNegativeConverter;

    @BeforeEach
    void setUp() {
        this.rgbToNegativeConverter = new RgbToNegativeConverter();
    }

    @Test
    void convertRgbToNegative() {

        byte[] expectedResult = {-103, 20, -126};

        // WHEN
        int r = 102;
        int g = 235;
        int b = 125;

        byte[] result = rgbToNegativeConverter.convertRgbToNegative(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);
    }

}