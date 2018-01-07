package com.avengers.bruce.Algorithm.basic.DataStructure.ListNode;

/*****
 * Created by apple on 2017/10/8.
 */
public class MainClass {

    public static void main(String[] args) {

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

        PrintList(S);

    }

    private static void PrintList(ListNode S) {

        System.out.println(
                S.val + " -> " +
                        S.next.val + " -> " +
                        S.next.next.val + " -> " +
                        S.next.next.next.val + " -> " +
                        S.next.next.next.next.val + " -> " +
                        S.next.next.next.next.next.val + " -> " +
                        S.next.next.next.next.next.next.val
        );

    }

}
