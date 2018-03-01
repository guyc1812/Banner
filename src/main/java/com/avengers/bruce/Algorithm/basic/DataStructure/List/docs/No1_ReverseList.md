# Reverse List

* **By iteration**

    ```java
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
    ```

* **By recursion**

    ```java
    private static ListNode reverseByRecursion(ListNode head) {
    
        if (head.next == null) {
            return head;
        }
        ListNode reverseNode = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    
    }
    ```
    
* **Test**

    ```java
    public static void main(String[] args) {
    
        ListNode node = new ListNode();
        ListNode head1 = new ListNode().getList();
        ListNode head2 = new ListNode().getList();
    
        node.printList(head1);
        // S -> T -> R -> A -> N -> G -> E
    
        ListNode reversedByIteration = reverseByIteration(head1);
        node.printList(reversedByIteration);
        // E -> G -> N -> A -> R -> T -> S
    
        ListNode reversedByRecursion = reverseByRecursion(head2);
        node.printList(reversedByRecursion);
        // E -> G -> N -> A -> R -> T -> S
    
    }
    ```
