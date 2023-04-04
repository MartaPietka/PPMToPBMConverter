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

//    @ParameterizedTest(name = "r: {0}, g: {1}, b: {2} -> {3}")
//    @CsvSource(textBlock = """
//            # red  green  blue  expected result
//              102, 235,   125,  {-103, 20, -126}
//              255, 255,   255,  {0, 0, 0}
//              0,   0,     0,    {255, 255, 255}
//              128, 128,   128,  {127, 127, 127}
//              115, 40,    60,   {-116, -41, -61}
//            """)

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