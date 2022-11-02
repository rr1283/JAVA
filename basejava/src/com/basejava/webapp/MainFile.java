package com.basejava.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {

        File dir = new File("./basejava/src/com/basejava/webapp");

        String filePath = "./basejava/src/com/basejava/webapp";
//        String filePath = ".\\.gitignore";
//        String filePath = ".\\.gitignore";
//        File dir = new File("./basejava/src/com/basejava/webapp");

//        File file = new File(filePath);
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException e) {
//            throw new RuntimeException("Error", e);
//        }
//
//
//        System.out.println(dir.isDirectory());
//        String[] list = dir.list();
//        if (list != null) {
//            for (String name : list) {
//                System.out.println(name);
//            }
//        }
//
//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        printFile(dir, "");
    }

    public static void printFile(File dir, String offset) throws IOException {
        File[] file = dir.listFiles();

        if (file != null) {
            for (File name : file) {
                if (name.isFile()) {
                    System.out.println(offset + "file: " + name.getName());
                } else if (name.isDirectory()) {
                    System.out.println(offset + "dir: " + name.getName());
                    printFile(name, offset + "  ");
                }
            }
        }
    }
}
