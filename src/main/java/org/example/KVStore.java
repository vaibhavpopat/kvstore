package org.example;

import java.util.HashMap;
import java.util.Map;
public class KVStore {
    private final Map<String, String> data;
    public KVStore() {
        data = new HashMap<>();
    }

    void add(String key, String value) {
        data.put(key, value);
    }

    String get(String key) {
        return data.get(key);
    }


    void remove(String key) {
        data.remove(key);
    }

    void update(String key, String value) {
        if(data.containsKey(key)) data.put(key, value);
    }

    boolean containsKey(String key) {
        return data.containsKey(key);
    }

}