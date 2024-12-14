package org.example;

import java.util.List;
/*
 Класс для хранения списка линий в формате JSON.
 */
public class LinesData {
    List<Line> lines;

    public LinesData(List<Line> lines) {
        this.lines = lines;
    }
}
