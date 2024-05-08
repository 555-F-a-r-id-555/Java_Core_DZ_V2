package org.example;

import java.io.File;

public class TreeV3 {

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
            int countFilesTotal = 0;
            int countFiles = 0;

            for (File f : files) {
                if (f.isFile()) {
                    countFilesTotal++;
                } else {
                    print(f, indent, countFilesTotal == 0);
                }
            }

            for (File f : files) {
                if (f.isFile()) {
                    countFiles++;
                    print(f, indent, countFiles == countFilesTotal);
                }
            }
        }

    }

}