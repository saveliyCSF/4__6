package com.company;

public class BubbleSort {

    public static SortInfo sortInfo(Integer[] arr) {
        int cmpCount = 0, chgCount = 0;
        long startTime = System.nanoTime();

        int size = arr.length;
        for (int i = 1; i < size; i++) {
            for (int j = size - 1; j >= i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    chgCount++;
                }
                cmpCount++;
            }
        }

        long finishTime = System.nanoTime();
        return new SortInfo(cmpCount, chgCount, (finishTime - startTime) / 1E6);
    }
}
