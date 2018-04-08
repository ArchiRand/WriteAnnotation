package com.myannotation.utils;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager<T> {

    private List<T> list = new ArrayList<>();

    public void save(T obj) {
        if (CheckObject.checkBeforeSave(obj)) {
            list.add(obj);
            System.out.println("Object - " + obj + " is successfully saved");
        } else {
            System.err.println("Impossible to save data. Incorrect values");
        }
    }
}
