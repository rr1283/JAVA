package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.basejava.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.Assert.*;

public class AbstractStorageTest {

    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_NOT_EXIST = "dummy";

    private static final String FULL_NAME1 = "Иванов Иван Иванович";
    private static final String FULL_NAME2 = "Петров Иван Иванович";
    private static final String FULL_NAME3 = "Смирнов Иван Иванович";
    private static final String FULL_NAME4 = "Синий Иван Иванович";
    private static final String FULL_NAME5 = "Красный Иван Иванович";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;
    private static final Resume RESUME_3_UPDATE;

    static {
        RESUME_1 = new Resume(UUID_1,FULL_NAME1);
        RESUME_2 = new Resume(UUID_2,FULL_NAME2);
        RESUME_3 = new Resume(UUID_3,FULL_NAME3);
        RESUME_4 = new Resume(UUID_4,FULL_NAME4);
        RESUME_3_UPDATE = new Resume(UUID_3,FULL_NAME3);
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    public void assertSize(int num) {
        assertEquals(num, storage.size());
    }

    @Test
    public void update() throws Exception {
        assertGet(RESUME_3);
        storage.update(RESUME_3_UPDATE);
        Assert.assertSame(RESUME_3_UPDATE, storage.get(UUID_3));
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> expected = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        List<Resume> actual = storage.getAllSorted();
        assertEquals(actual, expected);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_3);
        assertSize(2);
        storage.get(UUID_3);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    public void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume(UUID_NOT_EXIST));
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }
}