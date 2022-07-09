package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object uuid) {
        return storage.containsKey((String) uuid);
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

  //  @Override
  //  public Resume[] getAll() {
 //       return storage.values().toArray(new Resume[0]);
  //  }

    @Override
    public int size() {
        return storage.size();
    }
}
