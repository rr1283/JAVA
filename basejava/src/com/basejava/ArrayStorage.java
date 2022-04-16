package com.basejava;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static Resume[] storage = new Resume[10];

    void clear() {
        Arrays.fill(storage, null);
    }

     void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                i = storage.length;
            }
        }
    }

    Resume get(String uuid) {
        Resume tmp = null;
        for (int i = 0; i < storage.length; i++) {

            if (storage[i].uuid == uuid) {
                tmp = storage[i];
                i = storage.length;
            }
        }
        return tmp;
    }
    
    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                i = storage.length;
            }
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