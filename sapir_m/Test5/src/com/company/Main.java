package com.company;

public class Main {


    //--------------------------Sapir Michaeli-------------------------

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 2, 1};
        int[] b = {4, 3, 6, 2, 1};
        int[] c = {2, 6, 2, 1};
        int[] d = {2, 3, 4, 5};
        System.out.println(ex1A(a));
        System.out.println(ex1A(b));
        System.out.println(ex1A(c));
        System.out.println(ex1B(a));
        System.out.println(binary(a,0,a.length-1));
        System.out.println(binary(d,0,a.length-1));




    }



    public static boolean ex1A(int[] arr) {
       /* boolean large = false;
        boolean small = false;
        for (int i = 0; i < arr.length - 1 &&(!large); i++) {
            if (arr[i] < arr[i + 1]) {
                large = true;
                small=false;
            } else{
                small = true;
                large=false;}
        }

        if ((!large)&&small)
            return true;
        else
            return false;*/

        boolean flag = true;
        for (int i = 0; i < arr.length - 1 &&( flag); i++) {
            if (arr[i] < arr[i + 1]) {
                flag = true;
            }
            else
                flag = false;
            if (arr[i] > arr[i + 1]) {
                flag = true;
            }
        }
        if (flag)
            return true;
        else
            return false;

    }


    public static int ex1B(int[] arr) {
        // פתרון ליניארי
        int index=0;
        int i=0;
      while (arr[i]<arr[i+1]){
          index=i+1;
          i++;
        }
        return index;

      // יותר טוב אך לא גמור
        //binary( arr,  0,  arr.length -1);

    }


    static int binary(int[] arr, int left, int right) {
        if (right >= left) {
            int middle = left + (right - left) / 2; // כמה איברים במערך יש חלקי 2 -(right-left+1)/2
           if (arr[middle-1] < arr[middle])
                return middle;
            if (arr[middle] < arr[middle])
                return binary(arr, middle + 1, right); // נחפש בחצי הימני כאשר ה middle  עצמו לתוך בתחום החיפוש
            return binary(arr, left, middle - 1);
        }
        return -1;
    }







    public static void ex2(int[] arr) {
        for (int i = 0; i <arr.length ; i++) {
             partition(arr, 0, arr.length-1);

        }
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (pivot%2==0) {
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
