package com.company;

public class ShakerSort {

    public static SortInfo sortInfo(Integer[] arr) {
        int cmpCount = 0, chgCount = 0;
        long startTime = System.nanoTime();
        ;

        int buff = 0;
        int left = 0;
        int firstSwap = left;
        int right = arr.length - 1;
        int lastSwap = right;
        do {
            for (int i = left; i < right; i++) {//Слева направо
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                    lastSwap = i;
                    chgCount++;
                }
                cmpCount++;
            }

            if (right == lastSwap) {//если массив уже отсортирован
                long finishTime = System.nanoTime();
                return new SortInfo(cmpCount, chgCount, (finishTime - startTime) / 1E6);
            }

            //right--;
            right = lastSwap;//сохраняем последнюю перестановку как границу

//            if (left >= right) {//если границы сошлись
//                long finishTime = System.nanoTime();
//                return new SortInfo(cmpCount, chgCount, (finishTime - startTime) / 1E6);
//            }

            for (int i = right; i > left; i--) {//Справа налево
                if (arr[i - 1] > arr[i]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                    firstSwap = i;
                    chgCount++;
                }
                cmpCount++;
            }

            if (left == firstSwap) {//если все отсортировалось уже при проходе слева направо
                long finishTime = System.nanoTime();
                return new SortInfo(cmpCount, chgCount, (finishTime - startTime) / 1E6);
            }

            left = firstSwap;//сохраняем последнюю перестановку как границу
            //left++;
        } while (left < right);

        long finishTime = System.nanoTime();
        return new SortInfo(cmpCount, chgCount, (finishTime - startTime) / 1E6);
    }
}
