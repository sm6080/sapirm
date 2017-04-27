package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 7, 8, 10, 9, 7, 6, 5};
        System.out.println(isMountain(arr));


        //לצורך הבדיקה .. (פונקצית הבדיקה )
        int []arr2;
        Random random=new Random(System.currentTimeMillis());
        for (int i = 0; i <1000 ; i++) {
            arr2 = new int[1 + random.nextInt(100)];
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = random.nextInt(1000) - 500;// -500 - 500

            }
            arrangeAllEvenAtStart2(arr2);
            if (!isEvenFirst(arr2)) {
                System.out.println("your code is wrong");
                break;
            }
        }

    }

    //1a
    public static boolean isMountain(int[] arr) {
        boolean foundPeak = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (foundPeak)
                    return false;
            } else if (arr[i] > arr[i + 1]) {
                if (foundPeak)
                    foundPeak = true;
            } else
                return false;
        }
        return true;
    }


    //1b      o(logn)
    public static int findPeak(int[] arr, int from, int to) {
        if (from == to)
            return from;
        if (to - from == 1) {
            if (arr[from] > arr[to])
                return from;
            return to;
        }
        int middle = from + (to - from) / 2;
        boolean greatThanMyLeft = arr[middle] > arr[middle - 1];
        boolean greatThanMyRight = arr[middle] > arr[middle + 1];
        if (greatThanMyLeft && greatThanMyRight)
            return middle;
        if (greatThanMyLeft && !greatThanMyRight)
            return findPeak(arr, middle + 1, to);
        else
            return findPeak(arr, from, middle - 1);
    }


    //2
    public static void arrangeAllEventAtStart(int[] arr) {
        int i = -1, temp = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 == 0) {
                i++;
                if (j != i) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    //2 - version 2 -    moves from two sides
    static void arrangeAllEvenAtStart2(int[] arr) {
        int i = -1, temp = 0;
        int j = arr.length;
        while (true) {
            do {
                j--;
            } while (j > -1 && arr[j] % 2 != 0);
            do {
                i++;
            } while (i < arr.length && arr[i] % 2 == 0);

            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            } else {
                return;// out of the function
            }
        }
    }

    // פונקציה שבודקת את התנאים
    static boolean isEvenFirst(int []arr){
        boolean found=false;
        for (int i = 0; i <arr.length-1; i++) {
            if (arr[i] % 2 == 0) {
                if (found)
                    return false; // מצאתי זוגי אחרי שמצאתי אי זוגי אז false
            } else {
                found = true;
            }
        }
        return true;
    }
}
