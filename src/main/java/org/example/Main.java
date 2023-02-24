package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of(args[0]);

        StringBuilder sb = new StringBuilder();

        try (InputStream inputStream = Files.newInputStream(path)) {
            int content;
            while ((content = inputStream.read()) != -1) {
                sb.append(Integer.toHexString(content)).append(" ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(sb);
    }
}