package com.avengers.bruce.Algorithm.basic.DataStructure.Tree.BinaryTree;

/*****
 * Created by apple on 2017/10/8.
 */
public class No1_Depth {

    private static int maxDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    private static int minDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        return Math.min(left, right) + 1;

    }

    private static int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private static int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode();
        TreeNode root = node.getTree();

        int maxD = maxDepth(root);
        int minD = getMinDepth(root);

        System.out.println("min depth: " + minD);
        System.out.println("max depth: " + maxD);

    }


}
