package com.basejava.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapUuidStorageTest.class,
        MapResumeStorageTest.class,
        ObjectStreamStorageTest.class,
        ObjectStreamPathStorageTest.class,
        XmlPathStorageTest.class,
        JsonPathStorageTest.class,
        DataPathStorageTest.class
})

public class AllStorageTest {
}
