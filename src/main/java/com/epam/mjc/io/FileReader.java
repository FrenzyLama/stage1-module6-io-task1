package com.epam.mjc.io;

import java.io.*;
import java.util.logging.Logger;


public class FileReader {
    private final Mapper mapper = new Mapper();
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

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
            logger.warning(e.getMessage());
        }
        return profile;
    }
}
