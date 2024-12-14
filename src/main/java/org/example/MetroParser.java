package org.example;

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
        Elements lineElements = doc.select("div.js-metro-station"); // Обновите селектор, если нужно
        for (Element lineElement : lineElements) {
            String name = lineElement.attr("data-line-title");
            String number = lineElement.attr("data-line-id");
            if (!name.isEmpty() && !number.isEmpty()) {
                lines.add(new Line(name, number));
            }
        }
        return lines;
    }

    public List<Station> parseStations(Document doc) {
        List<Station> stations = new ArrayList<>();
        Elements stationElements = doc.select("div.js-metro-station");
        for (Element stationElement : stationElements) {
            Elements stationRows = stationElement.select("span.name");
            String line = stationElement.attr("data-line-id");
            for (Element row : stationRows) {
                String name = row.text();
                if (!name.isEmpty() && !line.isEmpty()) {
                    stations.add(new Station(name, line));
                }
            }
        }
        return stations;
    }
}
