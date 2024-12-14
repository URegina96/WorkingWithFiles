package org.example;

import java.util.List;
/*
 Класс для хранения списка станций в формате JSON.
 */
public class StationsData {
    List<Station> stations;

    public StationsData(List<Station> stations) {
        this.stations = stations;
    }
}
