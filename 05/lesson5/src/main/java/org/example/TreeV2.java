package org.example;

import java.io.File;

public class TreeV2 {

    public static void main(String[] args) {
        print(new File("."), "", true);

    }

    static void print(File file, String indent, boolean isLast) {


        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());


        File[] files = file.listFiles();

        if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (!files[i].isFile()) {
                        print(files[i], indent, i == files.length - 1);
                    }
                }

            int countFilesTotal = 0;
            for (File value : files) {
                if (value.isFile()) {
                    countFilesTotal++;
                }
            }
            int countFiles = 0;
            for (File value : files) {
                if (value.isFile()) {
                    countFiles++;
                    print(value, indent, countFiles == countFilesTotal);
                }
            }
        }
    }
}