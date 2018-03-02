# 23. Merge k Sorted Lists

* **Question**

    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

* **Merge K lists**

    ```java
    istNode mergeKListNode(ArrayList<ListNode> k) {
        if (k.size() == 0) {
            return null;
        }
        return mergeHelper(k, 0, k.size() - 1);
    }
    ```

* **Merge helper**

    ```java
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    ```

* **Merge two lists**

    ```java
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode('0');
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }
    ```