package org.example;

import java.util.HashMap;
import java.util.Map;

public class Transaction {

    private final Map<String, String> temp;

    public Transaction() {
        this.temp = new HashMap<>();
    }

    public void beginTx() {
        temp.clear();
    }

    public void commitTx(Map<String, String > data) {
        for(String key : temp.keySet()) {
            data.put(key, temp.get(key));
        }
    }

    public void rollbackTx() {
        temp.clear();
    }

    public void add(String key, String value) {
        temp.put(key, value);
    }

    public String get(String key) {
        return temp.get(key);
    }

    public void remove(String key) {
        temp.remove(key);
    }

    public void update(String key, String value) {
        if(temp.containsKey(key)) temp.put(key, value);
    }

    public boolean containsKey(String key) {
        return temp.containsKey(key);
    }
}
