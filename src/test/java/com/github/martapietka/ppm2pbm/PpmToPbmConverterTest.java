package com.github.martapietka.ppm2pbm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PpmToPbmConverterTest {

    private PpmToPbmConverter ppmToPbmConverter;

    @BeforeEach
    void setUp() {
        this.ppmToPbmConverter = new PpmToPbmConverter(128, new RgbToGrayscaleByMaxConverter());
    }
    @Test
    void convert() throws IOException, InvalidImageException {
        String expectedOutputString = """
                P1
                3 3
                0 0 1
                0 1 0
                0 0 0
                """;

        // WHEN
        InputStream inputStream = PpmToPbmConverterTest.class.getResourceAsStream("/3x3.ppm");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ppmToPbmConverter.convert(inputStream, outputStream);

        // THEN
        byte[] outputBytes = outputStream.toByteArray();
        Assertions.assertThat(outputBytes).asString().isEqualTo(expectedOutputString);
    }
}