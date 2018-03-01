# Last n nodes in list

* **Clip last n nodes**

    ```java
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
    ```

* **Test**
    ```java
    public static void main(String[] args) {

        ListNode node = new ListNode();
        ListNode head = new ListNode().getList();

        node.printList(head);
        System.out.print("Last 5 nodes: ");
        node.printList(nthToLast(head, 5));
      
        // S -> T -> R -> A -> N -> G -> E
        // Last 5 nodes: R -> A -> N -> G -> E

    }
    ```
