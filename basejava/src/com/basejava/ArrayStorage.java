package com.basejava;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    static void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = r;
        }
    }


    Resume get(String uuid) {
        Resume tmp = null; 
        for (int i = 0; i < storage.length; i++) {

            if (storage[i].uuid == uuid) {
                tmp = storage[i];
            }
        }
        return tmp;
    }
    
    void delete(String uuid) {
        if (storage[0].uuid == uuid) {
            storage[0] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
     Resume[] getAll() {
        return Arrays.copyOf(storage,storage.length);
    }

    int size() {
        return Array.getLength(storage);
    }
}