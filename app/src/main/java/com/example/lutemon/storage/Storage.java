package com.example.lutemon.storage;

import com.example.lutemon.model.Lutemon;
import java.util.HashMap;

public class Storage {
    private final HashMap<Integer, Lutemon> lutemons = new HashMap<>();
    private int nextId = 1;

    public int addLutemon(Lutemon lutemon) {
        lutemons.put(nextId, lutemon);
        return nextId++;
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

}
