package org.example;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
/*
 Класс для парсинга CSV файлов и получения списка объектов Station.
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public List<Station> parseCsv(InputStream inputStream) throws IOException {
        List<Station> stations = new ArrayList<>();
        try (Reader in = new InputStreamReader(inputStream)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                String name = record.get("station_name");
                String line = record.get("line_name");
                if (name != null && !name.isEmpty() && line != null && !line.isEmpty()) {
                    stations.add(new Station(name, line));
                } else {
                    System.err.println("Недостающие данные в записи: " + record);
                }
            }
        } catch (IOException e) {
            // Логирование ошибки
            System.err.println("Ошибка при чтении CSV-файла: " + e.getMessage());
            throw e; // Бросаем исключение выше
        }
        return stations;
    }
}
