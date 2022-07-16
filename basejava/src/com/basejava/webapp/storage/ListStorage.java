package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage<Integer> {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    protected Integer findSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            String uuid1 = storage.get(i).getUuid();
            if (Objects.equals(uuid1, uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        storage.add(r);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        int key = searchKey;
        storage.remove(key);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        int key = searchKey;
        return storage.get(key);
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        int key = searchKey;
        storage.set(key, r);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doGetAllSorted() {
        return new ArrayList<>(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
