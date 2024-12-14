package org.example;
/*
 Главный класс, который запускает программу. Он отвечает за выполнение шагов по парсингу данных, поиску файлов и записи результатов в JSON.
*/
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Шаг 1: Парсим данные с сайта (если необходимо)
            MetroParser metroParser = new MetroParser();
            Document doc = metroParser.getHtml("https://www.moscowmap.ru/metro.html"); // Используем реальный URL
            List<Line> lines = metroParser.parseLines(doc);
            List<Station> stations = metroParser.parseStations(doc);

            // Шаг 2: Парсинг JSON и CSV файлов из ресурсов
            JsonParser jsonParser = new JsonParser();
            CsvParser csvParser = new CsvParser();

            // Используем getResourceAsStream для доступа к файлам в resources
            InputStream jsonStream = Main.class.getClassLoader().getResourceAsStream("data.json");
            List<Station> stationsFromJson = jsonParser.parseJson(jsonStream, Station.class);

            InputStream csvStream = Main.class.getClassLoader().getResourceAsStream("data.csv");
            List<Station> stationsFromCsv = csvParser.parseCsv(csvStream);

            // Шаг 3: Обработка данных и запись в файлы
            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.writeJson(stations, lines);
            dataProcessor.writeJson(stationsFromJson, lines);
            dataProcessor.writeJson(stationsFromCsv, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
