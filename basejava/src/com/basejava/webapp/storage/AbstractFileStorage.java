package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//        clear
//        file назови files
//        files обязательно проверяй на null, так как если файлов не будет, то вернётся массив,
//        состоящий из нуля элементов, по которому можно итерироваться. А null вылетит если в
//        файловой системе что-то пошло не так - в этом случае бросай StorageException
//        size
//        Сделай просто directory.listFiles, проверь его по аналогии на null, и так как это массив, то вернуть можно length
//        doDelete
//        Если файл не был удалён - бросай StorageException
//        doGet
//        Нужно десериализовать резюме при помощи doRead, и обработать исключение
//        doGetAllSorted
//        Нужно десереализовать все резюме через doGet, и составить из них список


public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Clear error", null);
        }
        for (File f : files) {
            doDelete(f);
        }
    }

    @Override
    public int size() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Get size error", null);
        }
        return files.length;
    }

    @Override
    protected File findSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("Write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    protected Resume doGet(Resume r, File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("Get error", file.getName(), e);
        }
    }

    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("Delete error", file.getName());
        }
    }

    @Override
    protected List<Resume> doGetAllSorted() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("GetAll error", null);
        }
        List<Resume> list = new ArrayList<>();
        for (File f : files) {
            list.add(doGet(f));
        }
        return list;
    }
}
