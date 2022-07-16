package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected void doSave(Resume r, String searchKey) {
        String key = searchKey.toString();
        storage.put(key, r);
    }

    @Override
    protected void doDelete(String searchKey) {
        String key = searchKey;
        storage.remove(key);
    }

    @Override
    protected List<Resume> doGetAllSorted() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected Resume doGet(String searchKey) {
        String key = searchKey;
        return storage.get(key);
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        storage.replace(searchKey, r);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
