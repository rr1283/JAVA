package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapNameStorage extends AbstractStorage {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String findSearchKey(String fullName) {
        return fullName;
    }

    @Override
    protected boolean isExist(Object fullName) {
        return storage.containsValue((String) fullName);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        String key = searchKey.toString();
        storage.put(key, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        String key = (String) searchKey;
        storage.remove(key);
    }

    @Override
    protected List<Resume> doGetAllSorted() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        String key = (String) searchKey;
        return storage.get(key);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.replace((String) searchKey, r);
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
