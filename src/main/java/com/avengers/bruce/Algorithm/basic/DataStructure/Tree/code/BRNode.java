package com.avengers.bruce.Algorithm.basic.DataStructure.Tree.code;

public class BRNode <T extends Comparable<T>>{

    boolean color;
    T key;
    BRNode<T> left;
    BRNode<T> right;
    BRNode<T> parent;

    public BRNode(boolean color, T key, BRNode<T> left, BRNode<T> right, BRNode<T> parent) {
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return key + " " + (this.color? "R" : "B");
    }
}