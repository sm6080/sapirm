package com.company;

public class Main {

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(6);
        Node n3=new Node(5);
        Node n4=new Node(7);
        Node n5=new Node(9);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        bubbleSortLinkedList(n1);

    }
    public static void bubbleSortLinkedList(Node n) {
        int size = 1;
        Node temp = new Node(0);
        Node temp2 = new Node(0);

        while (n.next != null){
            size++;
            n=n.next;
        }

        int upTo = size; // האיבר האחרון
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            int i = 1;
            while (i < size) {

                if (n.value > n.next.value) {
                    temp.next = n.next; // prev
                    temp2 = n.next;
                    n.next = n.next.next;
                    temp2.next = n;
                    isSorted = false;
                }
                temp = temp2;
                n = n.next;
                i++;
            }
        }
        upTo--;
    }
}
