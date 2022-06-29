package com.basejava.webapp.storage;

public class ArrayStorageTest extends AbstractStorageTest {

    private static final Storage storage = new ArrayStorage();

    public ArrayStorageTest() {
        super(storage);
    }
}