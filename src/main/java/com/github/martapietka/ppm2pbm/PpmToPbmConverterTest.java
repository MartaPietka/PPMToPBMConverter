package com.github.martapietka.ppm2pbm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.*;
class PpmToPbmConverterTest {

    @Test
    void convert() {
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

        PpmToPbmConverter.convert(inputStream, outputStream);

        // THEN
        byte[] outputBytes = outputStream.toByteArray();

        Assertions.assertThat(outputBytes).asString().isEqualTo(expectedOutputString);
    }
}