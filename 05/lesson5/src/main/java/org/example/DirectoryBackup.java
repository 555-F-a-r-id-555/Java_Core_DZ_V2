package org.example;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryBackup {

    public static void main(String[] args) {
        String sourceDirectoryPath = "./";
        String backupDirectoryPath = sourceDirectoryPath + "backup/";

        Path sourceDirectory = Paths.get(sourceDirectoryPath);
        Path backupDirectory = Paths.get(backupDirectoryPath);

        try {
            Files.createDirectories(backupDirectory); // Создаем папку backup, если её нет
            Files.walkFileTree(sourceDirectory, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (dir.equals(backupDirectory)) { // Проверяем, что это не папка "backup"
                        return FileVisitResult.SKIP_SUBTREE; // Пропускаем содержимое папки "backup"
                    }
                    Path targetDir = backupDirectory.resolve(sourceDirectory.relativize(dir)); // Добавляем относительные пити к текущему пити
                    Files.createDirectories(targetDir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path targetFile = backupDirectory.resolve(sourceDirectory.relativize(file));
                    Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }

            });
            System.out.println("Копирование завершено.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
