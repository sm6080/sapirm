package com.company;

import java.util.Random;

/**
 * Created by Sapir Michaeli on 12.02.2017.
 */
public class Tar3 {



    public  int quickSelect(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int position = randomizedPartition(arr, l, r);
            if (position - l == k - 1) // הוא בדיוק במקום וזנ מה שאני צריך
                return arr[position];
            if (position - l > k - 1) {
                return quickSelect(arr, l, position - 1, k);
            } else
                return quickSelect(arr, position + 1, r, k - position + l - 1);
        }
        return Integer.MAX_VALUE; // כל המערך הם האיברים הקטנים
    }

    static int randomizedPartition(int[] arr, int low, int high) {
        if (high == low)
            return low;
        Random random = new Random(System.currentTimeMillis());
        int pos = random.nextInt(high - low) + low;
        int temp = arr[high];
        arr[high] = arr[pos];
        arr[pos] = temp;
        return partition(arr, low, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }


}
