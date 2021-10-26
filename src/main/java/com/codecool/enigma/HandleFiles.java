package com.codecool.enigma;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HandleFiles {
    private Path path;

    String getFileText(String filePath) throws IOException, EnigmaException {
        path = Path.of(filePath);
        System.out.println(path);
        if(fileExists(path)){
            String text = Files.readString(path);
            return text;
        } else {
            throw new EnigmaException("File not found.");
        }
    }

    private boolean fileExists(final Path path) {
        return Files.exists(path);
    }
}
