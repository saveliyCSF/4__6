package com.company;

public class ExperimentInfo {
    private SortInfo[] bubbleSortResults;
    private SortInfo[] shakerSortResults;

    public ExperimentInfo(int size) {
        bubbleSortResults = new SortInfo[size];
        shakerSortResults = new SortInfo[size];
    }

    public int getSize() {
        return bubbleSortResults.length;
    }

    public SortInfo getBubbleSortResult(int index) {
        return bubbleSortResults[index];
    }

    public SortInfo getShakerSortResult(int index) {
        return shakerSortResults[index];
    }


    public void setBubbleSortResults(int index, SortInfo si) throws Exception {
        if (index < 0 || index >= bubbleSortResults.length) {
            throw new Exception("Incorrect size");
        }
        bubbleSortResults[index] = si;
    }

    public void setShakerSortResults(int index, SortInfo si) throws Exception {
        if (index < 0 || index >= shakerSortResults.length) {
            throw new Exception("Incorrect size");
        }
        shakerSortResults[index] = si;
    }
}
