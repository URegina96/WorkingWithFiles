package org.example;
/*
Этот класс отвечает за получение HTML-кода страницы и парсинг данных о линиях и станциях московского метро.
*/
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetroParser {
    public Document getHtml(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public List<Line> parseLines(Document doc) {
        List<Line> lines = new ArrayList<>();
        Elements lineElements = doc.select("div.metro-line"); // CSS-селектор для линий метро
        for (Element lineElement : lineElements) {
            String name = lineElement.select("span.line-name").text();
            String number = lineElement.select("span.line-number").text();
            if (!name.isEmpty() && !number.isEmpty()) {
                lines.add(new Line(name, number));
            }
        }
        return lines;
    }

    public List<Station> parseStations(Document doc) {
        List<Station> stations = new ArrayList<>();
        Elements stationElements = doc.select("div.station"); // CSS-селектор для станций
        for (Element stationElement : stationElements) {
            String name = stationElement.select("span.station-name").text();
            String line = stationElement.select("span.station-line").text();
            if (!name.isEmpty() && !line.isEmpty()) {
                stations.add(new Station(name, line));
            }
        }
        return stations;
    }
}
