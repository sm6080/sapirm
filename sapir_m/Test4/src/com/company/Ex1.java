package com.company;

/**
 * Created by Sapir Michaeli on 20.02.2017.
 */
public class Ex1 <T>{


    //  a

    public static Node<Integer> sortKlists1(Node<Node<Integer>> head) {  //מחזירים Node<Integer> כי יש רק רשימה אחת ולא כמות של רשימות
        if (head==null)
            return null;
        while (head.next!=null) {
            head.value = merge(head.value, head.next.value);
            head.next = head.next.next;
        }
        return head.value;
    }


    //b
    // כל פעם נמזג שתי רשימות בנפרד וכך כל פעם נמזג שתיים באותו סדר גודל במקום אחת גדולה וקטנה
    public static Node<Integer> sortKlists2(Node<Node<Integer>> head) {
        //recursive version
        if (head == null)
            return null;
        if (head.next == null) // תנאי עצירה
            return head.value;
        Node<Node<Integer>> temp = new Node<>(null);
        Node<Node<Integer>> headResult = temp;
        while (head != null && head.next != null) {
            temp.next = new Node<>(merge(head.value, head.next.value));
            head = head.next.next;
            temp = temp.next;
        }
        if (head != null)   // יש לי עוד רשימה אחת
            temp.next = head;
        return sortKlists2(headResult.next);

    }



    // C








    public static <T extends  Comparable<T>> Node<T> merge(Node<T> a, Node<T> b) {

        Node<T> anchor = new Node(123);
        Node<T> tail = anchor;
        while (true) {
            if (a == null) {
//if either list runs out, use the other one.
                tail.next = b;
                break;
            } else if (b == null) {
                tail.next = a;
                break;
            }
            if (  b.value.compareTo(a.value)>=0 ) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        return anchor.next;
    }












}
