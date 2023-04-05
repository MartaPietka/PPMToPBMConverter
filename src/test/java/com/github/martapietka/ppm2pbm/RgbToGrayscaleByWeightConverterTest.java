package com.github.martapietka.ppm2pbm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RgbToGrayscaleByWeightConverterTest {

    private RgbToGrayscaleConverter rgbToGrayscaleConverter;

    @BeforeEach
    void setUp() {
        this.rgbToGrayscaleConverter = RgbToGrayscaleByWeightConverter.getInstance();
    }

    @ParameterizedTest(name = "r: {0}, g: {1}, b: {2} -> {3}")
    @CsvSource(textBlock = """
            # red  green  blue  expected result
              102, 235,   125,  183
              255, 255,   255,  255
              0,   0,     0,    0
              128, 128,   128,  128
              115, 40,    60,   65
            """)
    void convertRgbToGrayscale(int r, int g, int b, int expectedResult) {

        // WHEN
        int result = rgbToGrayscaleConverter.convertRgbToGrayscale(r, g, b);

        // THEN
        assertThat(result).isEqualTo(expectedResult);

    }
}