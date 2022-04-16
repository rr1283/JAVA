package com.basejava;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static Resume[] storage = new Resume[10000];

    int size = 0;

    void save(Resume r) {
        storage[size] = r;
        size++;
        return;
    }

    void delete(String uuid) {
        for (int i = 0; i < size + 1; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                size--;
                compress(storage);
                return;
            }
        }
    }

    void clear() {
        Arrays.fill(storage, size, storage.length - 1, null);
    }

    Resume get(String uuid) {
        for (int i = 0; i < size + 1; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            } else return null;
        }
        return null;
    }

    Resume[] compress(Resume[] array) {
        for (int i = 0; i < array.length; i++) {
            Resume cell = array[i];
            if (cell == null) {
                int j = i + 1;
                while (j < array.length && array[j] == null)
                    j++;
                if (j < array.length) {
                    array[i] = array[j];
                    array[j] = null;
                }
            }
        }
        return array;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}