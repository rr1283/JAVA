package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

import static java.lang.Math.*;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected void saveResume(Resume r, int index) {
        int i = abs(index) - 1;
        if (!((i == 0) & (size == 0))) {
            for (int t = size; t > i; t--) {
                storage[t] = storage[t - 1];
            }
        }
        storage[i] = r;
        size++;
    }

    protected void deleteResume(int index) {
        for (int t = index; t < size; t++) {
            storage[t] = storage[t + 1];
        }
        size--;
        storage[size] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
