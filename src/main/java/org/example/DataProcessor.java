package org.example;

import com.google.gson.Gson;
/*
 Класс для обработки данных и записи их в JSON файлы.
*/
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataProcessor {
    public void writeJson(List<Station> stations, List<Line> lines) throws IOException {
        Gson gson = new Gson();

        // Создаём JSON для станций
        StationsData stationsData = new StationsData(stations);
        String stationsJson = gson.toJson(stationsData);
        try (FileWriter writer = new FileWriter("stations.json")) {
            writer.write(stationsJson);
        }

        // Создаём JSON для линий
        LinesData linesData = new LinesData(lines);
        String linesJson = gson.toJson(linesData);
        try (FileWriter writer = new FileWriter("map.json")) {
            writer.write(linesJson);
        }
    }
}
