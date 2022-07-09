package com.basejava.webapp.storage;

public class MapNameStorageTest extends AbstractStorageTest {

    private static final Storage storage = new MapUuidStorage();

    public MapNameStorageTest() {
        super(storage);
    }
}
