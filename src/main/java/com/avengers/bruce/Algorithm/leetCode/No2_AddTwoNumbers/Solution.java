package com.avengers.bruce.Algorithm.leetCode.No2_AddTwoNumbers;

public class Solution {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode p = listNode;
        int sum = 0;

        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            sum = sum / 10;
            p = p.next;
        }
        return listNode.next;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(2);
        ListNode l15 = new ListNode(4);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(8);
        ListNode l18 = new ListNode(4);
        ListNode l19 = new ListNode(1);

        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        l17.next = l18;
        l18.next = l19;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(5);
        ListNode l24 = new ListNode(4);
        ListNode l25 = new ListNode(1);
        ListNode l26 = new ListNode(5);
        ListNode l27 = new ListNode(1);
        ListNode l28 = new ListNode(2);
        ListNode l29 = new ListNode(0);

        l2.next = l21;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        l27.next = l28;
        l28.next = l29;

        ListNode result = addTwoNumbers(l1, l2);
    }
}

