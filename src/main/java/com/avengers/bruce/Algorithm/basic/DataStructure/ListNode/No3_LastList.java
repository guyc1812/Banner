package com.avengers.bruce.Algorithm.basic.DataStructure.ListNode;

public class No3_LastList {

    private static ListNode nthToLast(ListNode head, int n) {

        if (head == null || n < 1) {
            return null;
        }

        ListNode l1 = head;
        ListNode l2 = head;

        for (int i = 0; i < n - 1; i++) {
            if (l2 == null) {
                return null;
            }
            l2 = l2.next;
        }
        while (l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;

    }

    public static void main(String[] args) {

        ListNode node = new ListNode();
        ListNode head = new ListNode().getList();

        node.printList(nthToLast(head, 5));

    }


}
