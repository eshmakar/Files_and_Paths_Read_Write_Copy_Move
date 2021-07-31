package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("hello.txt");
        if (!file.exists())//если такой файл не существует
            file.createNewFile();//то создает


        Files.copy(Paths.get("test.txt"), Paths.get("file2.txt"), StandardCopyOption.REPLACE_EXISTING); //копируем файл (StandardCopyOption.REPLACE_EXISTING - если есть, то заменяем этот файл, не объязательно)
        Files.move(Paths.get("file2.txt"), Paths.get("file3.txt"), StandardCopyOption.ATOMIC_MOVE); //перемещаем файл (или переименуем, как в этом случае)
        Files.deleteIfExists(Paths.get("file3.txt"));//если существует, то удаляем этот файл

        Path path = Paths.get("hello.txt").toAbsolutePath();//создаем полный путь к файлу
        byte[] bytes = Files.readAllBytes(path);//файл целиком помещаем в массив байтов
        for (byte b : bytes)
            System.out.print(b+ " ");//выводим обычном способом
//        Stream.of(Arrays.toString(Files.readAllBytes(path))).forEach(System.out::println);//или с помощью стрима

        //вместо FileWriter, OutputStream можно использовать просто Files для записи каких-то файлов, пример:
        Files.write(Paths.get("newFile.txt"), "это текст записи на файл".getBytes());

        //то же самое, вместо FileReader, InputStream можно через Files читать все данные, пример:
        Files.readAllLines(Paths.get("D:/someFile.txt")).forEach(System.out::println);

    }
}












