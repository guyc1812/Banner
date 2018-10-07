# [559. Maximum Depth of N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree/)

* **Question**

    Given a n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

* **Example**

    Given a 3-ary tree:   
    
    <img src="https://leetcode.com/static/images/problemset/NaryTreeExample.png" height="150px"> 
        
    We should return its max depth, which is 3.
    
    Note:
    
    * The depth of the tree is at most 1000.
    * The total number of nodes is at most 5000.

* **Solution**

    ```java
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
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
    
            int depth = 0;
            for (Node child : root.children)
                depth = Math.max(maxDepth(child), depth);
    
            return 1 + maxH;
        }
        
    }
    ```