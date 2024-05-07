package org.example;

import java.io.*;

public class DirectoryBackupv2 {
    private static String backupName;

    public static void main(String[] args) {
        String sourceDirectoryPath = "./"; // Путь к исходной директории (проекту)
        backupName = "backup2";
        String backupDirectoryPath = "./"+ backupName +"/"; // Путь к директории для бэкапа

        File sourceDirectory = new File(sourceDirectoryPath);

        if (sourceDirectory.exists()) {
            try {
                backupDirectory(sourceDirectory, new File(backupDirectoryPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Директория не существует.");
        }
    }

    public static void backupDirectory(File sourceDirectory, File backupDirectory) throws IOException {
        if (!backupDirectory.exists()) {
            backupDirectory.mkdirs(); // Создаем директорию для бэкапа, если её нет
        }

        File[] files = sourceDirectory.listFiles();
        if (files != null ) {
            for (File file : files) {
                if (!file.getName().equals(backupName)){

                    if (file.isDirectory()) {
                        // Рекурсивный вызов для обхода вложенных каталогов
                        backupDirectory(file, new File(backupDirectory, file.getName()));
                    } else {
                        // Копируем файл из исходной директории в директорию для бэкапа
                        copyFile(file, new File(backupDirectory, file.getName()));
                    }

                }

            }
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }
}
