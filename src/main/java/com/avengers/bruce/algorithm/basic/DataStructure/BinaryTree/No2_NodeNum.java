package com.avengers.bruce.algorithm.basic.DataStructure.BinaryTree;

public class No2_NodeNum {

    private static int numOfTreeNode(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;

    }

    private static int numOfLeafNode(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = numOfLeafNode(root.left);
        int right = numOfLeafNode(root.right);
        return left + right;

    }

    private static int numOfKLevelNode(TreeNode root, int k) {

        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int numsLeft = numOfKLevelNode(root.left, k - 1);
        int numsRight = numOfKLevelNode(root.right, k - 1);
        return numsLeft + numsRight;

    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode();
        TreeNode root = node.getTree();

        int numOfTreeNode = numOfTreeNode(root);
        int numOfLeafNode = numOfLeafNode(root);
        int numOfKLevelNode = numOfKLevelNode(root, 4);

        System.out.println("num of TreeNode: " + numOfTreeNode);
        System.out.println("num of LeafNode: " + numOfLeafNode);
        System.out.println("num of K Level : " + numOfKLevelNode);

    }


}
