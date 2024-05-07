package org.example;

import java.io.File;

public class Tree {

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param args
     */
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

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    print(files[i], indent, i == files.length - 1);
                }
            }
        }

//        File[] files = file.listFiles();
//
//        if (files != null) {     // Добавил проверку на null и удалил проверку на директории
//
//            int subDirTotal = 0;
//
//            for (int i = 0; i < files.length; i++) {
//                    subDirTotal++;
//            }
//
//            int subDirCounter = 0;
//            for (int i = 0; i < files.length; i++) {
//                    print(files[i], indent, subDirTotal == ++subDirCounter);
//            }
//        }

    }

}
