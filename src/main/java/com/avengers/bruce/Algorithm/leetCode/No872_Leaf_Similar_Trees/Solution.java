package com.avengers.bruce.Algorithm.leetCode.No872_Leaf_Similar_Trees;

import java.util.ArrayList;
import java.util.List;

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