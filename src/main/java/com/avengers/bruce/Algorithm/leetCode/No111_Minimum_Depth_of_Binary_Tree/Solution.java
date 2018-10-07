package com.avengers.bruce.Algorithm.leetCode.No111_Minimum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// BFS
class Solution1 {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> que = new LinkedList();
        int level = 1;
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                TreeNode node = que.poll();
                if (node.left == null && node.right == null)
                    return level;
                if (node.left != null)
                    que.add(node.left);
                if (node.right != null)
                    que.add(node.right);
                size--;
            }
            level++;
        }
        return level;
    }

}

// DFS
// 此题用DFS不好，当二叉树极端不平衡时(左500右1)，没有BFS效率高。
class Solution2 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

}