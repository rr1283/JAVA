package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
//    private static final int STORAGE_LIMIT = 10000;
//    private final Resume[] storage = new Resume[STORAGE_LIMIT];

//    private int size = 0;

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
        }
        size++;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}