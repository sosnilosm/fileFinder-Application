package com.example.filefinderjavafx;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;


public class FileFinder {
    public static String folderWorm(String dirName, String strToFind){
        File dir = new File(dirName);
        StringBuilder res = new StringBuilder();
        int counter = 0;

        if (dir.isDirectory()) {
            for (File item : Objects.requireNonNull(dir.listFiles())) {
                if (!item.isDirectory() && strFinder(item, strToFind)) {
                    res.append(++counter).append(".)\t").append(item.getPath()).append("\n");
                }
            }
        }
        return res.toString();
    }

    public static String fileToStr(String fileDir) {
        StringBuilder fileText = new StringBuilder();
        try (FileReader reader = new FileReader(fileDir)) {
            int c;
            while ((c=reader.read()) != -1) {
                fileText.append((char) c);
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileText.toString().toLowerCase(Locale.ROOT);
    }

    public static boolean strFinder(File file, String strToFind) {
        return fileToStr(file.getPath()).contains(strToFind.toLowerCase());
    }
}
