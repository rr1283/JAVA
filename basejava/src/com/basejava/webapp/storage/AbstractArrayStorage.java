package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


    @Override
    public boolean isExist(Object index){
        return (Integer) index >= 0;
    };

    @Override
    public void doUpdate(Resume r, Object index) {
      //  int index = getIndex(r.getUuid());
        if ((Integer) index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[(Integer) index] = r;
        }
    }

    /**
     * @return
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }


    @Override
    public void doSave(Resume r, Object index) {
      //  int index = getIndex(r.getUuid());
        if ((Integer) index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertElement(r, (Integer) index);
            size++;
        }
    }
    @Override
    public void doDelete(Object index) {
        if ((Integer) index < 0) {
            throw new NotExistStorageException(index.toString());
        } else {
            fillDeletedElement((Integer) index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume doGet(Object index) {
        //int index = getIndex(uuid);
        if ((Integer) index < 0) {
            throw new NotExistStorageException(index.toString());
        }
        return storage[(Integer) index];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract Integer findSearchKey(String uuid);
}