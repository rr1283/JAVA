package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Object findSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract List<Resume> doGetAllSorted();

    private Object findExistingSearchKey(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object findNotExistingSearchKey(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public void save(Resume r) {
        Object searchKey = findNotExistingSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = findExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    public void update(Resume r) {
        Object searchKey = findExistingSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = findExistingSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> storage = doGetAllSorted();
        Collections.sort(storage);
        return storage;
    }
}
