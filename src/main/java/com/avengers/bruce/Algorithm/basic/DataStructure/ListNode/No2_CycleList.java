package com.avengers.bruce.Algorithm.basic.DataStructure.ListNode;

public class No2_CycleList {

    /**
     * 给定一个单链表，只给出头指针h：
     * 1、如何判断是否存在环？
     * 2、如何知道环的长度？
     * 3、如何找出环的连接点在哪里？
     * 4、带环链表的长度是多少？
     * <p>
     * 解法：
     * <p>
     * 1.使用追赶的方法，设定两个指针slow、fast，从头指针开始，每次分别前进1步、2步。
     * 如存在环，则两者相遇；如不存在环，fast遇到NULL退出。
     * <p>
     * 2.记录下问题1的碰撞点p，slow、fast从该点开始，再次碰撞所走过的操作数就是环的长度s。
     * <p>
     * 3.定理：碰撞点p到连接点的距离=头指针到连接点的距离。
     * 因此，分别从碰撞点、头指针开始走，相遇的那个点就是连接点。
     * 该定理的证明可参考：http://fayaa.com/tiku/view/7/
     * <p>
     * 4.问题3中已经求出连接点距离头指针的长度，加上问题2中求出的环的长度，
     * 二者之和就是带环单链表的长度
     */

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow, fast;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode().getCycleList();

        // 环形链表可不能打印啊....
        // node.printList(head);

        System.out.print(hasCycle(head));

    }


}
