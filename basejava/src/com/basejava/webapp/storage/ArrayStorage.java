package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    private int size = 0;

    public void save(Resume r) {
        if ((isExistsResume(String.valueOf(r)) == 0) & (arrayIsFull())) {
            storage[size] = r;
            size++;
            System.out.println("Резюме " + String.valueOf(r) + " сохранено");
        }
    }

    public void update(Resume r, Resume rNew) {
        if (isExistsResume(String.valueOf(r)) == 1) {
            for (int i = 0; i < size; i++) {
                if (r.getUuid() == storage[i].getUuid()) {
                    storage[i] = rNew;
                }
            }
        }
    }

    public void delete(String uuid) {
        if (isExistsResume(String.valueOf(uuid)) == 1) {
            for (int i = 0; i < size; i++) {
                if (uuid == storage[i].getUuid()) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        if (isExistsResume(String.valueOf(uuid)) == 1) {
            for (int i = 0; i < size; i++) {
                if (uuid == storage[i].getUuid()) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public int isExistsResume(String uuid) {
        int t = 0;
        for (int i = 0; i < size; i++)
            if (uuid == storage[i].getUuid()) {
                t = 1;
                System.out.println("Резюме " + uuid + " найдено");
            }
        if (t == 0) {
            System.out.println("Резюме " + uuid + " не найдено");
        }
        return t;
    }

    public boolean arrayIsFull() {
        if (size < storage.length) {
            System.out.println("Доступно: " + Math.subtractExact(storage.length, size));
            return true;
        } else {
            System.out.println("Свободного места нет");
        }
        return false;
    }
}