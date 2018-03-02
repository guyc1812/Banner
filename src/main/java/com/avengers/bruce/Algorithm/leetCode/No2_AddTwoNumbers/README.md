# 2. Add Two Numbers

* **Question**

    Given two non-empty linked lists representing two non-negative integers.<br>
    The digits are stored in reverse order and each of their nodes contain a single digit.<br> 
    Add the two numbers and return it as a linked list.
    
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    
* **Example**
    
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)<br>
    Output: 7 -> 0 -> 8<br>
    Explanation: 342 + 465 = 807.<br>
    
* **Solution**

    List Node
    ```java
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    ```
    
    ```java
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
    ```

* **Test**

    ```java
     public static void main(String[] args) {
 
         ListNode result = addTwoNumbers(l1, l2);        
         // li: 1489421342
         // l2: 0215145465
 
         do {
             System.out.print(result.val+" ");
             result = result.next;
         }while (result!=null);
         
         // 7086654071
 
     }   
    ```