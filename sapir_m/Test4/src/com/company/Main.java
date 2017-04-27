package com.company;



// -------------------- Sapir Michaeli ----------------------



public class Main {

    public static void main(String[] args) {
        Node<Integer> n1=new Node<>(1);
        Node<Integer> n2=new Node<>(5);
        Node<Integer> n3=new Node<>(6);
        Node<Integer> n4=new Node<>(7);
        Node<Integer> n5=new Node<>(9);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        n5.prev=n4;
        n4.prev=n3;
        n3.prev=n2;
        n2.prev=n1;

        Node<Node<Integer>> head1= new Node<>(n1);

        Node<Integer> n6=new Node<>(4);
        Node<Integer> n7=new Node<>(5);
        Node<Integer> n8=new Node<>(6);
        Node<Integer> n9=new Node<>(7);
        Node<Integer> n10=new Node<>(12);

        n6.next=n7;
        n7.next=n8;
        n8.next=n9;
        n9.next=n10;

        Node<Node<Integer>> head2= new Node<>(n6);

        Node<Integer> n11=new Node<>(10);
        Node<Integer> n12=new Node<>(11);
        Node<Integer> n13=new Node<>(15);
        Node<Integer> n14=new Node<>(17);
        Node<Integer> n15=new Node<>(18);

        n11.next=n12;
        n12.next=n13;
        n13.next=n14;
        n14.next=n15;

        Node<Node<Integer>> head3= new Node<>(n11);

        head1.next=head2;
        head2.next=head3;

        Node<Integer>  merged=Ex1.merge(n1,n6);
        printLinkedList(merged);


        Node<Integer>  merged2=Ex1.sortKlists2(head1);
        printLinkedList(merged2);



       //Ex2.bubbleSortLinkedList(n1);


    }
    public static void printLinkedList(Node node){
        while (node!=null){
            System.out.print(node.value+" ");
            node=node.next;
        }
        System.out.println();
    }

}

