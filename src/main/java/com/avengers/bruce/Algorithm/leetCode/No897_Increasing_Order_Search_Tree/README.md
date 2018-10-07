# [897. Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree/)

* **Question**

    Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
    
* **Example**

    Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
    
    ```
           5
          / \
        3    6
       / \    \
      2   4    8
     /        / \ 
    1        7   9
    ```

    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
    
    ```
     1
      \
       2
        \
         3
          \
           4
            \
             5
              \
               6
                \
                 7
                  \
                   8
                    \
                     9  
    ```

* **Solution**

    ```java
    //Definition for a binary tree node.
    class TreeNode {
        double val;
        TreeNode left;
        TreeNode right;
        TreeNode(double x) { val = x; }
    }
    
    class Solution {
    
        public static int round  = 0;
    
        public static TreeNode increasingBST(TreeNode root) {
            return increasingBST(root, null);
        }
    
        public static TreeNode increasingBST(TreeNode root, TreeNode tail) {
            if (root == null) return tail;
            TreeNode res = increasingBST(root.left, root);
            root.left = null;
            root.right = increasingBST(root.right, tail);
            return res;
        }  
    
    }
    ```