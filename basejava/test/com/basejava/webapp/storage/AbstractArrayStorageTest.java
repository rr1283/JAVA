package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest {
    final private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_5 = "uuid5";
    private static final String UUID_NOT_EXIST = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final Resume RESUME_5 = new Resume(UUID_5);
    private static final Resume RESUME_3_UPDATE = new Resume(UUID_3);

    protected AbstractArrayStorageTest(Storage storage) {
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
        Assert.assertEquals(num, storage.size());
    }

    @Test
    public void update() throws Exception {
        assertGet(RESUME_3);
        storage.update(RESUME_3_UPDATE);
        Assert.assertEquals(RESUME_3_UPDATE, storage.get(UUID_3));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] expected = new Resume[storage.size()];
        expected = storage.getAll();
        assertSize(expected.length);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_5);
        assertGet(RESUME_5);
        assertSize(4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.save(RESUME_4);
        storage.delete(UUID_4);
        assertSize(3);
        storage.get(UUID_4);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_3);
    }

    public void assertGet(Resume r) {
        Assert.assertEquals(r, storage.get(r.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_NOT_EXIST);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.clear();
        storage.delete(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.clear();
        storage.update(RESUME_3);
    }

    @Test
    public void clear() throws Exception {
        Resume[] expected = new Resume[storage.size()];
        storage.clear();
        assertSize(0);
        expected = storage.getAll();
        assertSize(expected.length);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void storageOverflow() throws Exception {
        try {
            storage.clear();
            int t = 1;
            for (int i = 1; i < 10001; i++) {
                String str = "uuid" + Integer.toString(t++);
                storage.save(new Resume(str));
            }
        } catch (StorageException e) {
            fail("переполнение произошло раньше времени");
        }
        try {
            storage.save(new Resume("uuid10001"));
        } catch (StorageException e) {
            fail("произошло переполнение");
        }
    }
}
