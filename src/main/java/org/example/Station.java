package org.example;
/*
 Класс, представляющий станцию метро.
 */
public class Station {
    String name;
    String line;

    public Station(String name, String line) {
        this.name = name;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Station{name='" + name + "', line='" + line + "'}";
    }
}
