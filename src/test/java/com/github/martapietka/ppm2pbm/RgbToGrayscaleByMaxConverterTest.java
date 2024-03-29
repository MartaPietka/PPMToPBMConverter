package com.github.martapietka.ppm2pbm;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RgbToGrayscaleByMaxConverterTest {

    private RgbToGrayscaleConverter rgbToGrayscaleConverter;

    @BeforeEach
    void setUp() {
        this.rgbToGrayscaleConverter = new RgbToGrayscaleByMaxConverter();
    }

    @ParameterizedTest(name = "r: {0}, g: {1}, b: {2} -> {3}")
    @CsvSource(textBlock = """
            # red  green  blue  expected result
              102, 235,   125,  235
              255, 255,   255,  255
              0,   0,     0,    0
              128, 128,   128,  128
              115, 40,    60,   115
            """)
    void convertRgbToGrayscale(int r, int g, int b, int expectedResult) {

        // WHEN
        int result = rgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);

    }
}