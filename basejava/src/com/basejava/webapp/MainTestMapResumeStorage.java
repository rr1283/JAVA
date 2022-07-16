package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.MapResumeStorage;

public class MainTestMapResumeStorage {

    static final MapResumeStorage MAP_STORAGE = new MapResumeStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1","Иванов Иван Иванович");
        Resume r2 = new Resume("uuid2","Петров Иван Иванович");
        Resume r3 = new Resume("uuid3","Смирнов Иван Иванович");
        Resume r5 = new Resume("uuid5","Синий Иван Иванович");
        Resume r7 = new Resume("uuid7","Красный Иван Иванович");

        System.out.println("save");
        MAP_STORAGE.save(r7);
        MAP_STORAGE.save(r2);
        MAP_STORAGE.save(r3);
        MAP_STORAGE.save(r5);
        MAP_STORAGE.save(r1);
        //  MAP_STORAGE.save(r5);
        System.out.println("save");
        printAll();
        MAP_STORAGE.update(r5);
        System.out.println("update");

        System.out.println("Size: " + MAP_STORAGE.size());
//
        System.out.println("Get r1: " + MAP_STORAGE.get(r1.getUuid()));
//
        //  System.out.println("Get dummy: " + MAP_STORAGE.get("dummy"));
//
        printAll();
//
        MAP_STORAGE.delete(r1.getUuid());
        System.out.println("delete r1");
        System.out.println("Size: " + MAP_STORAGE.size());
        printAll();
        MAP_STORAGE.clear();
        printAll();
//
        System.out.println("Size: " + MAP_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : MAP_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }

}
