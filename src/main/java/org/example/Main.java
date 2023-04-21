package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static List<Worker> workerList;


    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("src\\main\\resources\\employees.csv");

        workerList = CheckingWorker.toCheck(filePath);

        workerList.forEach(System.out::println);

        System.out.println(Worker.emptyWorker());

        Worker[] workers = workerList.toArray(new Worker[0]);

    }
}