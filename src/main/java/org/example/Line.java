package org.example;
/*
 Класс, представляющий линию метро.
 */
public class Line {
    String name;
    String number;

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Line{name='" + name + "', number='" + number + "'}";
    }

}
