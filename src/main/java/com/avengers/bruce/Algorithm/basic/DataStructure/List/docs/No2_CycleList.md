# Cycle List

* **Question**

    给定一个单链表，只给出头指针h：<br>
    1、如何判断是否存在环？<br>
    2、如何知道环的长度？<br>
    3、如何找出环的连接点在哪里？<br>
    4、带环链表的长度是多少？
    
* **Solution**

    1.使用追赶的方法，设定两个指针slow、fast，从头指针开始，每次分别前进1步、2步。<br>
    如存在环，则两者相遇；如不存在环，fast遇到NULL退出。
    
    2.记录下问题1的碰撞点p，slow、fast从该点开始，再次碰撞所走过的操作数就是环的长度s。
    
    3.定理：碰撞点p到连接点的距离=头指针到连接点的距离。<br>
    因此，分别从碰撞点、头指针开始走，相遇的那个点就是连接点。<br>
    该定理的证明可参考：http://fayaa.com/tiku/view/7/
    
    4.问题3中已经求出连接点距离头指针的长度，加上问题2中求出的环的长度，二者之和就是带环单链表的长度
    
* **Code**

    ```java
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
    ```
    
* **Test**

    ```java
    public static void main(String[] args) {
        ListNode head = new ListNode().getCycleList();
        System.out.print(hasCycle(head));
        // true
    }
    ```