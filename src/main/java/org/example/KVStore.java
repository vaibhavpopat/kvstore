package org.example;

import java.util.HashMap;
import java.util.Map;
public class KVStore {
    private final Map<String, String> data;
    private boolean isTxnl;
    private Transaction tx;

    public KVStore() {
        data = new HashMap<>();
    }

    public void add(String key, String value) {
        if(isTxnl) {
            tx.add(key, value);
        } else {
            data.put(key, value);
        }
    }

    // TODO - Probably need to update this - to read in transaction details also (based on txn isolation levels)
    public String get(String key) {
        if(isTxnl) {
            return tx.get(key);
        } else {
            return data.get(key);
        }
    }


    public void remove(String key) {
        if(isTxnl) {
            tx.remove(key);
        } else {
            data.remove(key);
        }
    }

    public void update(String key, String value) {
        if(isTxnl) {
            tx.update(key, value);
        } else {
            if(data.containsKey(key)) data.put(key, value);
        }
    }

    public boolean containsKey(String key) {
        if(isTxnl) {
            return tx.containsKey(key);
        } else {
            return data.containsKey(key);
        }
    }

    public void clear() {
        if(isTxnl) {
            cleanUpTx();
        }
        data.clear();
    }

    public void beginTx() {
        tx = new Transaction();
        tx.beginTx();
        isTxnl = true;
    }

    public void commitTx() {
        tx.commitTx(data);
        cleanUpTx();
    }

    public void rollbackTx() {
        tx.rollbackTx();
        cleanUpTx();
    }

    private void cleanUpTx() {
        tx = null;
        isTxnl = false;
    }

}