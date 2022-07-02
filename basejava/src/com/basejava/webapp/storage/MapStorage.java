package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> collection = new HashMap<>();

    @Override
    protected String findSearchKey(String uuid) {
        for (Map.Entry<String, Resume> entry : collection.entrySet()) {
            String uuid1 = entry.getValue().getUuid();
            if (Objects.equals(uuid1, uuid)) {
                return uuid;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        String key = r.getUuid();
        collection.put(key, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        String key = (String) searchKey;
        collection.remove(key);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        String key = (String) searchKey;
        return collection.get(key);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        collection.replace((String) searchKey, r);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public Resume[] getAll() {
        return collection.values().toArray(new Resume[collection.size()]);
    }

    @Override
    public int size() {
        return collection.size();
    }
}
