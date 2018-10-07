package com.avengers.bruce.Algorithm.leetCode.No559_Maximum_Depth_of_N_ary_Tree;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution1 {
    private int maxDepth = Integer.MIN_VALUE;

    public int maxDepth(Node root) {
        if (root == null) return 0;
        walk(root, 0);
        return maxDepth;

    }

    private void walk(Node node, int depth) {
        depth++;
        if (node.children == null || node.children.isEmpty()) {
            maxDepth = Math.max(depth, maxDepth);
            return;
        }
        for (Node child : node.children) walk(child, depth);
    }

}

class Solution2 {

    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int maxH = 0;
        for (Node child : root.children)
            maxH = Math.max(maxDepth(child), maxH);

        return 1 + maxH;
    }
}

