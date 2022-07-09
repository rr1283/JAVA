package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Test;

import static com.basejava.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;
import static org.junit.Assert.fail;

public class ArrayStorageTest extends AbstractStorageTest {

    private static final Storage storage = new ArrayStorage();

    public ArrayStorageTest() {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() throws Exception {
        storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                String str = "uuid" + (i + 1);
                storage.save(new Resume(str));
            }
        } catch (StorageException e) {
            fail("переполнение произошло раньше времени");
        }
        storage.save(new Resume("uuid_Overflow"));
    }

}