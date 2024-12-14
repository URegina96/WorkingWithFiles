package org.example;
/*
 Главный класс, который запускает программу. Он отвечает за выполнение шагов по парсингу данных, поиску файлов и записи результатов в JSON.
*/
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Шаг 1: Парсим данные с сайта
            MetroParser metroParser = new MetroParser();
            Document doc = metroParser.getHtml("https://example.com/metro"); // Замените на реальный URL
            List<Line> lines = metroParser.parseLines(doc);
            List<Station> stations = metroParser.parseStations(doc);

            // Шаг 2: Поиск файлов
            FileSearcher fileSearcher = new FileSearcher();
            List<File> files = fileSearcher.findFiles("E:/path/to/folder"); // Замените на реальный путь
            for (File file : files) {
                System.out.println("Found file: " + file.getName());
            }

            // Шаг 3: Парсинг JSON и CSV файлов
            JsonParser jsonParser = new JsonParser();
            CsvParser csvParser = new CsvParser();
            List<Station> stationsFromJson = jsonParser.parseJson("data.json", Station.class);
            List<Station> stationsFromCsv = csvParser.parseCsv("data.csv");

            // Шаг 4: Обработка данных и запись в файлы
            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.writeJson(stations, lines);
            dataProcessor.writeJson(stationsFromJson, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
