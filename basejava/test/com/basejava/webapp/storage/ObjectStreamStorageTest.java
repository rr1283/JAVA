package com.basejava.webapp.storage;

import com.basejava.webapp.storage.strategy.Serializer;

public class ObjectStreamStorageTest extends AbstractStorageTest {
    public ObjectStreamStorageTest() {
        super(new FileStorage(STORAGE_DIR, new Serializer()));
    }
}
