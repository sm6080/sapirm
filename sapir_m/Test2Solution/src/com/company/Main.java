package com.company;

import java.security.InvalidParameterException;
import java.util.Random;

public class Main {

    static Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) {


        //-----------------------Main-------------------------


        int[] a = {2, 3, 4, 7, 9, 12, 56};
        System.out.println(tar1(a, 3));

        System.out.println(tar1Solution(a, 3));

        int[] a2 = {0, 6, 10};
        System.out.println(tar1(a2, 2));

        int[][] arr = {{1, 3, 5, 7}, {2, 4, 10, 16}, {3, 6, 12, 18}, {4, 8, 14, 20}};
        System.out.println(tar2(arr, 4));


    }


    public static int tar1(int arr[], int m) {
        int min = Integer.MAX_VALUE;
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i <= arr.length - m; i++) {
            if (arr[i + m - 1] - arr[i] < min)
                min = arr[i + m - 1] - arr[i];
        }
        return min;

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

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // נשתמש בפונקציה quickSelect שמחזירה את האיבר ה k , ונמשור אותו ,נעבור על המערך שלנו רק על השורות ונשאל אם האיבר הזה לא שווה לא ברגע שמצאנו שווה תצא מהפונקציה ותחזיר אמת אחרת יחזיר שקר נמור את זה ע"י דגל - משתנה בוליאני שהוא בעצם יאמר את התשובה
    public static boolean tar2(int[][] arr, int x) {
        boolean flag = false;
        for (int i = 0; i < arr.length && flag == false; i++) {
            int n = quickSelect(arr[i], 0, arr.length - 1, x);
            if (n != x) {
                flag = false;
            }
            flag = true;

        }
        if (flag)
            return true;
        return false;
    }

    public static int quickSelect(int[] arr, int l, int r, int k) {
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


    //-----------------------solution---------------------

    //ניצור משתנה סטטי רנדום ונשלח את quickSort  עם  randomizedPartition ... הפונקציה שלי טובה אך צריך להוסיף את הבדיקות
    public static int tar1Solution(int[]arr, int m) {
        if (m == 0 || arr.length == 0)
            return 0;
        if (arr.length < m)
            return -1;
        quickSort(arr, 0, arr.length - 1);
        int minDiff = Integer.MAX_VALUE;
        //  int first=0, last=0;
        for (int i = 0; i + m - 1 < arr.length; i++) {
            int diff = arr[i + m - 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
                //first = i;
                // last = i + m - 1;
            }
        }
        return minDiff;
    }






    public static boolean tar2Solution(int[][] mat, int x) {
        int n = mat.length;
        int i = 0, j = n - 1;  // מיקום האיבר בשורה הימנית למעלה
        while (i <= n && j >= 0) {
            if (mat[i].length != n) // בדיקה לא חובה)  האם המטריצה ריבועית
                throw new InvalidParameterException("row" + i + "is not length:" + n);
            if (mat[i][j] == x)
                return true;
            if (mat[i][j] > x)
                j--;  // יורד בעמודה
            else i++; //עולה בשורה
        }
        return false;
    }








}
