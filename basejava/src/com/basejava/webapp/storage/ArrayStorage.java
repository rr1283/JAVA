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
        if ((isExistsResume(String.valueOf(r)) == 0) & (size < storage.length)) {
            storage[size] = r;
            size++;
        }
    }

    /*
        Реализуйте в ArrayStorage метод update(Resume resume). Запустите его в MainTestArrayStorage
        Сделайте проверки в:
      //  get,
      //  update,
      //  delete
        на наличие резюме в storage
     //   save на отсутствие резюме в storage
     //   save на переполнение storage
      //  Выводите в консоль информативные предупреждения, для указанных выше проверок, с указанием uuid
    */
    public void update(Resume r) {
        if (isExistsResume(String.valueOf(r)) == 1) {
            for (int i = 0; i < size; i++) {
                if (r.getUuid() == storage[i].getUuid()) {
                    storage[i] = storage[i];
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
}