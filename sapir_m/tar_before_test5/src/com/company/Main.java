package com.company;

public class Main {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        System.out.println(sumSubArray(a));
        System.out.println(naiveSumSubArray(a));

    }

    // פונקציה שמקבלת מערך int  ומחזירה את הסכום של כל תתי המערכים שלו. תת מערך- מערך שהחל ממקום כלשהוא במערך הנתון עד מקום כלשהוא
    //(n-i)        (n-i)*i   =   (n-i)(i+1)
    public static long sumSubArray(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] * (i + 1) * (arr.length - i));
        }
        return sum;
    }

    //naive solution
    public static long naiveSumSubArray(int[] arr) {
        long sum = 0;
        final int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }
}
