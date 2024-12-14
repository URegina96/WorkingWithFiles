package org.example;
/*
Этот класс парсит JSON-файлы и возвращает список объектов.
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {
    public <T> List<T> parseJson(InputStream inputStream, Class<T> clazz) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            Gson gson = new Gson();
            Type listType = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, listType);
        }
    }
}
