package com.company;

public class OrderedGenerator implements DataGenerator {
    @Override
    public Integer[] create(int size) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < data.length; i++)
            data[i] = i;
        return data;
    }
}
