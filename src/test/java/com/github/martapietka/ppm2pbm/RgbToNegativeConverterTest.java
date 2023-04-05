package com.github.martapietka.ppm2pbm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RgbToNegativeConverterTest {

    private RgbToNegativeConverter rgbToNegativeConverter;

    @BeforeEach
    void setUp() {
        this.rgbToNegativeConverter = new RgbToNegativeConverter();
    }

    @ParameterizedTest(name = "r: {0}, g: {1}, b: {2} -> expectedR: {3}, expectedG: {4}, expectedB: {5}")
    @CsvSource(textBlock = """
            # red   green   blue   expectedR   expectedG   expectedB
              102,  235,    125,   -103,       20,         -126
              255,  255,    255,   0,          0,          0
              0,    0,      0,     -1,         -1,         -1
              128,  128,    128,   127,        127,        127
              115,  40,     60,    -116,       -41,        -61
            """)
    void convertRgbToNegative(int r, int g, int b, byte expectedR, byte expectedG, byte expectedB) {

        // WHEN
        byte[] result = rgbToNegativeConverter.convertRgbToNegative(r, g, b);

        // THEN
        assertThat(result[0]).isEqualTo(expectedR);
        assertThat(result[1]).isEqualTo(expectedG);
        assertThat(result[2]).isEqualTo(expectedB);
    }
}