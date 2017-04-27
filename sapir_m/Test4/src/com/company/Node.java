package com.company;

/**
 * Created by hackeru on 16.02.2017.
 */
public class Node<T> {
    T value;
    Node<T> next; // מצביע מסוג Node  שה value שלו הוא T
    Node<T> prev;

    public Node(T value) {
        this.value = value;
    }

}
