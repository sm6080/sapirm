package com.company;

import java.security.InvalidParameterException;

/**
 * Created by Sapir Michaeli on 20.02.2017.
 */
public class MinHeap {
    // יוצרים מערך Comparable   כי זה ברי השוואה
    private Comparable[] arr;
    private int size; // כמה בפועל אני משתמש מתוך ה 10

    public MinHeap() {
        arr = new Comparable[10];
        size = 0;
    }

    public MinHeap(Comparable[] arr) {
        this.arr = arr;
        size = arr.length;
        for (int i = size / 2; i >= 0; i--) {// מתחילים מהאמצע כי אחרי SIZE/2 כולם עלים ואין מה לעשות לגביהם כי הם ממילא ערימה חוקית
            heapify(i);
        }
    }

    public int getSize() {
        return size;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void heapify(int i) { // (מתקנת לפי מטה) מתקנת את העץ ערימת מקסימום חוקי
        int smallest = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if (l < size && arr[l].compareTo( arr[smallest])<0)// האם הבן השמאלי גדול וממני והאם בכלל יש לי בן שמאלי
            smallest = l;
        if (r < size && arr[r].compareTo( arr[smallest])<0)
            smallest = r;
        if (smallest != i) {
            Comparable temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(smallest);
        }
    }


    //log(n)
    private void bubbleUp(int i) {
        int p; // parent
        while (i != 0 && arr[(p = parent(i))].compareTo( arr[i])>0) {  //השמה  (p=parent(i))  כל עוד לא הגעתי לשורש והאבא קטן מילדו
            Comparable temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            i = p;
        }
    }

    //log(n)
    public void insertBe(int x) {
        if (size == arr.length) {
            int[] temp = new int[size * 2];  //עשינו כפול 2 כדי שהגדילה תהיה פרופורציונאלית
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        int i = size;
        size++;
        arr[i] = x;
        bubbleUp(i);
    }


    //o(n)
    public int getMax() {
        if (size == 0)
            throw new IndexOutOfBoundsException();

        int result = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > result)
                result = arr[i];
        }
        return result;

    }


    public int extractMaxBe() {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        if (size == 1) {
            size--;
            return arr[0];
        }
        int max = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapify(0);
        return max;
    }

}
