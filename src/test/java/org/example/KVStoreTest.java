package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KVStoreTest {

    KVStore kvStore = new KVStore();

    @Test
    void add() {
        kvStore.add("k1", "v1");
        Assertions.assertEquals("v1", kvStore.get("k1"));
    }

    @Test
    void remove() {
        kvStore.add("k1", "v1");
        Assertions.assertEquals("v1", kvStore.get("k1"));
        kvStore.remove("k1");
        Assertions.assertFalse(kvStore.containsKey("k1"));
    }

    @Test
    void update() {
        kvStore.add("k1", "v1");
        Assertions.assertEquals("v1", kvStore.get("k1"));
        kvStore.update("k1", "v2");
        Assertions.assertEquals("v2", kvStore.get("k1"));
    }
}