package com.avengers.bruce.Algorithm.leetCode.No897_Increasing_Order_Search_Tree;

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

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t1_5 = new TreeNode(1.5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t2.left = t1;
        t6.right = t8;
        t8.left = t7;
        t8.right = t9;
        t1.right = t1_5;
        TreeNode res = increasingBST(t5);
        System.out.println();
    }

}