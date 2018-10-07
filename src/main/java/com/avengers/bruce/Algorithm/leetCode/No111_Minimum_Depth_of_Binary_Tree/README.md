# [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree)

* **Question**

    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.
    
* **Example**

    Given binary tree [3,9,20,null,null,15,7],

    ```
        3
       / \
      9  20
        /  \
       15   7
    ```

    return its minimum depth = 2.

* **Solution**

    ```java
    //Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
    ```