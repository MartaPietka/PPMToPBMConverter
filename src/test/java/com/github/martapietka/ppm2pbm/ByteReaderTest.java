package com.github.martapietka.ppm2pbm;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteReaderTest {

    @Test
    void convertBytesToInt() throws IOException {

        int expectedResult = 2023;

        // WHEN
        byte[] array = {0x32, 0x30, 0x32, 0x33, 0xA, 0x38};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
        int result = ByteReader.convertBytesToInt(byteArrayInputStream);

        int remainingByte = byteArrayInputStream.read();

        // THEN
        assertThat(result).isEqualTo(expectedResult);
        assertThat(remainingByte).isEqualTo(0x38);
    }
}
