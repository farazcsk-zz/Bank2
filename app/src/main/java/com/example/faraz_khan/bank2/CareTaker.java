package com.example.faraz_khan.bank2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faraz-khan on 11/27/15.
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

