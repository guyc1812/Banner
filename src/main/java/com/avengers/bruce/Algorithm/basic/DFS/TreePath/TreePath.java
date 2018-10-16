package com.avengers.bruce.Algorithm.basic.DFS.TreePath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class TreePath {

    public static List<List<TreeNode>> binaryTreePaths(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();

        if (root == null) return list;

        iterator(root, list, new LinkedList<>());
        return list;
    }

    public static void iterator(TreeNode root, List<List<TreeNode>> paths, LinkedList<TreeNode> singlePath) {
        singlePath.add(root);

        if (root.left == null && root.right == null){
            paths.add(new ArrayList<>(singlePath));
        }

        if (root.left != null)
            iterator(root.left, paths, singlePath);

        if (root.right != null)
            iterator(root.right, paths, singlePath);

        singlePath.removeLast();

    }


    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();

        if (root == null) return list;

        iterator(root,list,"");
        return list;
    }

    public static void iterator(TreeNode root, List<String> list, String string) {
        string += root.val + " ";
        System.out.println(string);

        if (root.left == null && root.right == null){
            list.add(string.trim().replace(" ", "->"));
        }

        if (root.left != null)
            iterator(root.left, list, string);

        if (root.right != null)
            iterator(root.right, list, string);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.left = new TreeNode(9);
        root.left.left.left.left.left = new TreeNode(10);
        root.left.left.left.left.left.left = new TreeNode(11);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        List<List<TreeNode>> btPaths = binaryTreePaths(root);
        List<String> btPaths2 = binaryTreePaths2(root);
        System.out.println();
    }

}


//        1
//       / \
//      2   3
//     / \   \
//    4   5   6
//  8    /
//  9   7
//  10
//  11