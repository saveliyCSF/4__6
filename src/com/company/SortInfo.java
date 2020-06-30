package com.company;

public class SortInfo {
    private int cmpCount;
    private int chgCount;
    private double timeMs;

    public SortInfo(int cmpCount, int chgCount, double timeMs) {
        this.cmpCount = cmpCount;
        this.chgCount = chgCount;
        this.timeMs = timeMs;
    }

    public int getCmpCount() {
        return cmpCount;
    }

    public int getChgCount() {
        return chgCount;
    }

    public double getTimeMs() {
        return timeMs;
    }
}
