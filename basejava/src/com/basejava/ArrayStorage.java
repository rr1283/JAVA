package com.basejava;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                size--;
                System.arraycopy(compress(storage), 0, storage, 0, storage.length);
                return;
            }
        }
    }

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    Resume[] compress(Resume[] array) {
        Resume[] tmpArray = new Resume[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                System.arraycopy(array, i, tmpArray, j++, 1);
        }
        return tmpArray;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}