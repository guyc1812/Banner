package com.avengers.bruce.algorithm.basic.DataStructure.BinaryTree;

/*****
 * Created by apple on 2017/10/8.
 */
public class No3_IsBalanced {

    /**
     * public boolean isBalanced(BinaryTreeNode root){
     * if(root ==null)
     * return true;
     * int left = treeDepth(root.leftNode);
     * int right = treeDepth(root.rightNode);
     * int diff = left - right;
     * if(diff > 1 || diff <-1)
     * return false;
     * return isBalanced(root.leftNode) && isBalanced(root.rightNode);
     * }
     */

    public boolean isBalanced(TreeNode root) {
        int depth = 0;
        return isBalanced(root, depth);
    }

    public boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left - right;
            if (diff <= 1 && diff >= -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }


}
