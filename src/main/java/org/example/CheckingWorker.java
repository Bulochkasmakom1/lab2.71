package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 /**Класс CheckingWorker отвечает за проверку и сохранение данных о работниках в файл.
         Он содержит два метода, которые выполняют эти функции.*/
public class CheckingWorker {
     /**Метод check принимает коллекцию работников и путь к файлу, в который нужно сохранить информацию о них.
     Он преобразует каждого работника в строку, используя метод toString, и сохраняет полученные строки в файл.*/

     public void check(Collection<Worker> workers, Path filePath) {
        try {
            Collection<? extends CharSequence> workersToCheck = workers
                    .stream()
                    .map(Worker::toString)
                    .collect(Collectors.toCollection(ArrayList::new));
            Files.write(filePath, workersToCheck, Charset.defaultCharset());
        } catch (IOException e) {
            System.err.println("Something went wrong when checking workers");
        }
    }

     /**Метод toCheck читает данные о работниках из указанного файла и возвращает список работников.
     Если файл не найден, метод генерирует исключение FileNotFoundException.*/
    /** filePath - путь к файлу, содержащему данные о работниках.*/
    public static List<Worker> toCheck(
            Path filePath)
            throws IOException {
        if (Files.notExists(filePath)) {
            throw new FileNotFoundException("File with filePath = " + filePath + "is not found");
        }
        try (Stream<String> stream = Files.lines(filePath, StandardCharsets.UTF_8)) {
            return stream
                    .map(line -> {
                        String[] fields = line.split(",");
                        return new Worker(
                                Long.parseLong(fields[0].trim()),
                                fields[1].trim(),
                                fields[2].trim(),
                                fields[3].trim(),
                                fields[4].trim(),
                                Integer.parseInt(fields[5].trim())
                        );
                    })
                    .collect(Collectors.toList());
        }
    }
}
