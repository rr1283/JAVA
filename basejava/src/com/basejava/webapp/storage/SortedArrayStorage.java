package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

import static java.lang.Math.*;

public class SortedArrayStorage extends AbstractArrayStorage {
    public void save(Resume r) {

        int index = getIndex(r.getUuid());
        int i = abs(index) - 1;

        if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if ((i == 0) & (size == 0)) {
            storage[i] = r;
            size++;
        } else {
            for (int t = size; t > i; t--) {
                storage[t] = storage[t - 1];
            }
            storage[i] = r;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            for (int t = index; t < size; t++) {
                storage[t] = storage[t + 1];
            }
            size--;
            storage[size] = null;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
