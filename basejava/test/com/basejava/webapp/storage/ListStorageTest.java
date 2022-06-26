package com.basejava.webapp.storage;

public abstract class ListStorageTest extends AbstractArrayStorageTest {

    private static final Storage storage = new ListStorage();

    public ListStorageTest() {
        super(storage);
    }
}
