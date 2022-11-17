package com.basejava.webapp.storage;

import com.basejava.webapp.storage.strategy.Serializer;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    public ObjectStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new Serializer()));
    }
}
