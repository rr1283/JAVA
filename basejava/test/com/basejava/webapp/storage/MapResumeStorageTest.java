package com.basejava.webapp.storage;

public class MapResumeStorageTest extends AbstractStorageTest {

    private static final Storage storage = new MapUuidStorage();

    public MapResumeStorageTest() {
        super(storage);
    }
}
