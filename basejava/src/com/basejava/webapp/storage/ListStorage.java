package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage {

    protected List<Resume> collection = new ArrayList<>();

    @Override
    protected Integer findSearchKey(String uuid) {
       // if(collection.isEmpty()) return 0;
        for (int i = 0; i < collection.size(); i++) {
            String uuid1 = collection.get(i).getUuid();
            if (Objects.equals(uuid1, uuid)) {
                return i;
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
        collection.add(r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        int key = (Integer) searchKey;
        collection.remove(key);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        int key = (Integer) searchKey;
        return collection.get(key);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        int key = (Integer) searchKey;
        collection.set(key, r);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public Resume[] getAll() {
        return collection.toArray(new Resume[collection.size()]);
    }

    @Override
    public int size() {
        return collection.size();
    }
}
