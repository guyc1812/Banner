package com.avengers.bruce.Algorithm.basic.DataStructure.List.code;

import lombok.Setter;

public class ListNode {

    ListNode next;
    @Setter
    char val;

    ListNode() {}

    public ListNode(char x) {
        val = x;
        next = null;
    }

    public ListNode add(ListNode node){

        ListNode cur = next;
        while (cur!=null){
            cur = cur.next;
        }

        cur=node;

        return this;
    }

    public ListNode getList() {

        ListNode S = new ListNode('S');
        ListNode T = new ListNode('T');
        ListNode R = new ListNode('R');
        ListNode A = new ListNode('A');
        ListNode N = new ListNode('N');
        ListNode G = new ListNode('G');
        ListNode E = new ListNode('E');

        S.next = T;
        T.next = R;
        R.next = A;
        A.next = N;
        N.next = G;
        G.next = E;

        return S;

    }

    public ListNode getCycleList() {

        ListNode S = new ListNode('A');
        ListNode T = new ListNode('A');
        ListNode R = new ListNode('A');
        ListNode A = new ListNode('B');
        ListNode N = new ListNode('C');
        ListNode G = new ListNode('C');
        ListNode E = new ListNode('C');

        S.next = T;
        T.next = R;
        R.next = A;
        A.next = N;
        N.next = G;
        G.next = E;
        E.next = A;

        return S;

    }

    void printList(ListNode node) {

        while (node != null) {
            if (node.next != null) {
                System.out.print(node.val + " -> ");
            } else {
                System.out.print(node.val + "\n");
            }
            node = node.next;
        }

    }

}
