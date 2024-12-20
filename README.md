# Цель                                       

Цель данного проекта — разработка программы, которая собирает данные о станциях и линиях Московского метрополитена из различных источников, парсит их и сохраняет в формате JSON. Программа должна обеспечить:

1. Получение данных о станциях и линиях с веб-страницы.
2. Поиск файлов форматов JSON и CSV в заданном каталоге.
3. Парсинг данных из найденных JSON и CSV файлов.
4. Сохранение собранных данных в два выходных JSON файла: один с информацией о станциях, другой — с данными о линиях метрополитена.

## Описание решения                                   

В проекте реализовано несколько классов, каждый из которых отвечает за определённую функциональность:

1. **MetroParser**: Класс, который отвечает за получение HTML-кода страницы и парсинг данных о станциях и линиях. Использует библиотеку Jsoup для выполнения HTTP-запросов и обработки HTML-кода.

    - Метод `getHtml(String url)`: Получает HTML-код страницы по указанному URL.
    - Метод `parseLines(Document doc)`: Извлекает данные о линиях метро.
    - Метод `parseStations(Document doc)`: Извлекает данные о станциях метро.

2. **FileSearcher**: Класс, который осуществляет поиск файлов форматов JSON и CSV в указанной директории и всех её подкаталогах.

    - Метод `findFiles(String directoryPath)`: Рекурсивно ищет файлы с расширениями `.json` и `.csv`.

3. **JsonParser**: Класс, который отвечает за парсинг данных из JSON-файлов.

    - Метод `parseJson(InputStream inputStream, Class<T> clazz)`: Принимает поток данных JSON и возвращает список объектов заданного класса.

4. **CsvParser**: Класс, который отвечает за парсинг данных из CSV-файлов.

    - Метод `parseCsv(InputStream inputStream)`: Принимает поток данных CSV и возвращает список объектов Station.

5. **DataProcessor**: Класс, который обрабатывает данные и записывает их в выходные JSON-файлы.

    - Метод `writeJson(List<Station> stations, List<Line> lines)`: Создаёт и записывает данные о станциях и линиях в соответствующие JSON-файлы.

6. **Station** и **Line**: Классы, представляющие объекты станции и линии метро соответственно. Каждый класс содержит методы для представления данных в читаемом виде.

7. **Main**: Главный класс программы, который координирует выполнение всех шагов:

    - Сначала парсит данные с сайта.
    - Затем ищет и парсит данные из JSON и CSV файлов.
    - Наконец, обрабатывает и сохраняет результаты в выходные JSON файлы.

## Использование               

1. Убедитесь, что у вас установлены все необходимые библиотеки (например, Jsoup и Gson).
2. Поместите ваши JSON и CSV файлы в папку `src/main/resources`.
3. Запустите класс `Main`, который инициирует процесс сбора и обработки данных.
4. После выполнения программы вы получите два JSON файла: `stations.json` и `map.json`, содержащие информацию о станциях и линиях метро соответственно.

## Заключение                        

Данная программа иллюстрирует процесс сбора, обработки и сохранения данных из различных источников, используя принципы объектно-ориентированного программирования и библиотеки для обработки HTML и JSON.            


                         
                           
                                   
                                        