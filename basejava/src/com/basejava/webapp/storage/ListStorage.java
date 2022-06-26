package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage {

    protected Collection<Resume> collection = new ArrayList<>();

    @Override
    public void save(Resume r) {
        collection.add(r);
    }

    @Override
    public Resume get(String uuid) {
        for (Iterator<Resume> iterator = collection.iterator(); iterator.hasNext(); ) {
            Resume r = iterator.next();
            if (Objects.equals(r.getUuid(), uuid)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void delete(String uuid) {
        for (Iterator<Resume> iterator = collection.iterator(); iterator.hasNext(); ) {
            Resume r = iterator.next();
            if (Objects.equals(r.getUuid(), uuid)) {
                iterator.remove();
            }
        }
    }

    @Override
    public void update(Resume r) {
        for (Iterator<Resume> iterator = collection.iterator(); iterator.hasNext(); ) {
            Resume r1 = iterator.next();
            if (Objects.equals(r1, r)) {
                iterator.remove();
            }
        }
        collection.add(r);
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
