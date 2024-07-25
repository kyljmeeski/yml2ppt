package com.kyljmeeski.yml2ppt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        String content = readFileFromResources("presentation.json");
        System.out.println(content);
    }

    public static String readFileFromResources(String fileName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        try (
                InputStream inputStream = classLoader.getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
