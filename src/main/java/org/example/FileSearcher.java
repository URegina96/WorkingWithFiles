package org.example;
/*
Этот класс занимается поиском файлов форматов JSON и CSV в указанных папках.
*/
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    public List<File> findFiles(String directoryPath) {
        List<File> files = new ArrayList<>();
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    files.addAll(findFiles(file.getAbsolutePath())); // Рекурсивно ищем в подкаталогах
                } else if (file.getName().endsWith(".json") || file.getName().endsWith(".csv")) {
                    files.add(file);
                }
            }
        }
        return files;
    }
}
