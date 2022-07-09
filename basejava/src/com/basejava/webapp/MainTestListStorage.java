package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.ListStorage;

public class MainTestListStorage {

    static final ListStorage LIST_STORAGE = new ListStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1","Иванов Иван Иванович");
        Resume r2 = new Resume("uuid2","Петров Иван Иванович");
        Resume r3 = new Resume("uuid3","Смирнов Иван Иванович");
        Resume r5 = new Resume("uuid5","Синий Иван Иванович");
        Resume r7 = new Resume("uuid7","Красный Иван Иванович");

        System.out.println("save");
        LIST_STORAGE.save(r7);
        LIST_STORAGE.save(r2);
        LIST_STORAGE.save(r3);
        LIST_STORAGE.save(r5);
        LIST_STORAGE.save(r1);
       // LIST_STORAGE.save(r5);
        System.out.println("save");

        LIST_STORAGE.update(r5);
        System.out.println("update");

        System.out.println("Size: " + LIST_STORAGE.size());

        System.out.println("Get r1: " + LIST_STORAGE.get(r1.getUuid()));

       // System.out.println("Get dummy: " + LIST_STORAGE.get("dummy"));

        printAll();

        LIST_STORAGE.delete(r1.getUuid());
        System.out.println("delete r1");
        printAll();
        LIST_STORAGE.clear();
        printAll();

        System.out.println("Size: " + LIST_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : LIST_STORAGE.doGetAllSorted()) {
            System.out.println(r);
        }
    }
}
