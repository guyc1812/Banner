package com.avengers.bruce.Algorithm.basic.DataStructure.ListNode;

public class No1_ReverseList {

    private static ListNode reverseByIteration(ListNode node) {

        ListNode prev = null;

        while (node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }

        return prev;
    }

    private static ListNode reverseByRecursion(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode reverseNode = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;

    }

    public static void main(String[] args) {

        ListNode node = new ListNode();
        ListNode head1 = new ListNode().getList();
        ListNode head2 = new ListNode().getList();

        node.printList(head1);

        ListNode reversedByIteration = reverseByIteration(head1);
        node.printList(reversedByIteration);

        ListNode reversedByRecursion = reverseByRecursion(head2);
        node.printList(reversedByRecursion);

    }

}
