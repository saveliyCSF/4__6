package com.company;

import org.jfree.data.xy.XYSeries;

import java.util.Arrays;

public class Experiment {
    public static ExperimentInfo experiment(DataGenerator gen, int maxSize) throws Exception {
        ExperimentInfo ei = new ExperimentInfo(maxSize);
        for (int i = 0; i < maxSize; i++) {
            Integer[] arr = gen.create(i);
            ei.setBubbleSortResults(i, BubbleSort.sortInfo(Arrays.copyOf(arr, arr.length)));
            ei.setShakerSortResults(i, ShakerSort.sortInfo(Arrays.copyOf(arr, arr.length)));
            //ei.setInsertSortResults(i, InsertSort.sortInfo(arr));
        }
        return ei;
    }

    public static void applyBubbleCmpLine(ExperimentInfo info, XYSeries series) {
        series.clear();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getBubbleSortResult(i).getCmpCount());
        }
    }

    public static void applyBubbleChgLine(ExperimentInfo info, XYSeries series) {
        series.clear();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getBubbleSortResult(i).getChgCount());
        }
    }

    public static void applyBubbleTimeLine(ExperimentInfo info, XYSeries series) {
        series.clear();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getBubbleSortResult(i).getTimeMs());
        }
    }

    public static void applyShakerCmpLine(ExperimentInfo info, XYSeries series) {
        series.clear();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getShakerSortResult(i).getCmpCount());
        }
    }

    public static void applyShakerChgLine(ExperimentInfo info, XYSeries series) {
        series.clear();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getShakerSortResult(i).getChgCount());
        }
    }

    public static void applyShakerTimeLine(ExperimentInfo info, XYSeries series) {
        series.clear();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getShakerSortResult(i).getTimeMs());
        }
    }


//    public static XYSeries getBubbleCmpLine(ExperimentInfo info) {
//        XYSeries series = new XYSeries("Bcmp");
//        int size = info.getSize();
//        for (int i = 0; i < size; i++) {
//            series.add(i, info.getBubbleSortResult(i).getCmpCount());
//        }
//        return series;
//    }
//
//    public static XYSeries getShakerCmpLine(ExperimentInfo info) {
//        XYSeries series = new XYSeries("Scmp");
//        int size = info.getSize();
//        for (int i = 0; i < size; i++) {
//            series.add(i, info.getShakerSortResult(i).getCmpCount());
//        }
//        return series;
//    }
}
