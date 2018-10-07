# [872. Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)

* **Question**

    Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

    <img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png" height="150px"> 
    
* **Example**

    In the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
    
    Two binary trees are considered leaf-similar if their leaf value sequence is the same.
    
    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
    
    Note:
    
    * Both of the given trees will have between 1 and 100 nodes.

* **Solution**

    ```java
    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
    
            list1 = isLeafAdd(root1, list1);
            list2 = isLeafAdd(root2, list2);
    
            if(list1==null && list2==null) return true;
    
            if((list1==null && list2!=null) || (list1!=null && list2==null)) return false;
            return list1.equals(list2);
        }
    
        public List<Integer> isLeafAdd(TreeNode root, List<Integer> list) {
    
            if (root == null) return list;
    
            if(root.left==null && root.right==null) {
                list.add(root.val);
            }
    
            isLeafAdd(root.left, list);
            isLeafAdd(root.right, list);
            return list;
        }
    
    }
    ```