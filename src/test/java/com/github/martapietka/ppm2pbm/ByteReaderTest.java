package com.github.martapietka.ppm2pbm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteReaderTest {

    @Test
    void convertBytesToInt() throws IOException {

        int expectedInt = 2023;
        byte[] array = {0x32, 0x30, 0x32, 0x33};

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);

        Assertions.assertEquals(expectedInt, ByteReader.convertBytesToInt(byteArrayInputStream));
    }
}
