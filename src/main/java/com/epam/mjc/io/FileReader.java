package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    private final Mapper mapper = new Mapper();

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (FileInputStream input = new FileInputStream(file)) {
            StringBuilder stringBuilder = new StringBuilder();

            int ch;
            while ((ch = input.read()) != -1) {
                stringBuilder.append((char) ch);
            }

            profile = mapper.mapToProfile(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return profile;
    }
}
