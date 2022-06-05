package com.basejava.webapp;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.SortedArrayStorage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r5 = new Resume("uuid5");
        Resume r7 = new Resume("uuid7");

        ARRAY_STORAGE.save(r7);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r1);
      //  ARRAY_STORAGE.save(r5);

        ARRAY_STORAGE.update(r5);
        System.out.println("update");

        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));

      //  System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();

        ARRAY_STORAGE.delete(r1.getUuid());
        System.out.println("delete r1");
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}