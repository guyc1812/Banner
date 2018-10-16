# Burn a Binary Tree

* **Question**

    一个二叉树，假设都是用绳子做的边，每条边燃烧需要1s，如果从某个叶子结点开始点燃，需要多长时间烧完？

* **Idea**

    ![image](https://oss.guyuchen.com/deadpool/images/burntree.jpg)

* **Solution**

    ```java
    //Definition for a binary tree node.
    class  TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class BurnTree {

        static int maxDepth = Integer.MIN_VALUE;
        static int maxPath = Integer.MIN_VALUE;
        static List<TreeNode> path = new ArrayList<>();

        public static int burnTime(TreeNode root, TreeNode leaf) {
            if (root == null) return 0;

            walkToFindTargetPath(root, leaf, new LinkedList<>());
            maxDepth = Integer.MIN_VALUE;

            int pathLength = path.size() - 1;
            for (int i = 0; i < pathLength - 1; i++) {
                TreeNode currentNode = path.get(i);
                if (currentNode.left == path.get(i + 1)) {
                    // 不进入目标叶子节点所在分支
                    walkToGetMaxDepth(currentNode.right, 0);
                    maxPath = Math.max(maxPath, maxDepth + pathLength - i);
                } else {
                    // 不进入目标叶子节点所在分支
                    walkToGetMaxDepth(currentNode.left, 0);
                    maxPath = Math.max(maxPath, maxDepth + pathLength - i);
                }
            }

            return maxPath;
        }

        // 可以优化，在找寻目标叶子结点所在路径的同时，分别计算左右子树的最大深度
        // 这样在循环path链表的时候，对于root子树中，非目标叶子结点所在子树的最大深度可以直接获取
        // 减少"一半"的DFS
        public static void walkToFindTargetPath(TreeNode root, TreeNode leaf, LinkedList<TreeNode> normalPath) {
            normalPath.add(root);

            if (root.left == null && root.right == null && root == leaf)
                path = new ArrayList<>(normalPath);

            if (root.left != null)
                walkToFindTargetPath(root.left, leaf, normalPath);

            if (root.right != null)
                walkToFindTargetPath(root.right, leaf, normalPath);

            normalPath.removeLast();
        }

        public static void walkToGetMaxDepth(TreeNode root, int depth) {

            if(root==null) return;

            depth++;

            if (root.left == null && root.right == null)
                maxDepth = Math.max(depth, maxDepth);

            if (root.left != null)
                walkToGetMaxDepth(root.left, depth);

            if (root.right != null)
                walkToGetMaxDepth(root.right, depth);
        }


        public static void main(String[] args) {

            TreeNode root = new TreeNode(0);
            TreeNode note1 = new TreeNode(1);
            TreeNode note2 = new TreeNode(2);
            TreeNode note3 = new TreeNode(3);
            TreeNode note4 = new TreeNode(4);
            TreeNode note5 = new TreeNode(5);
            TreeNode note6 = new TreeNode(6);
            TreeNode note7 = new TreeNode(7);
            TreeNode note8 = new TreeNode(8);
            TreeNode note9 = new TreeNode(9);
                                                        //           0
            root.left = note1;                          //          / \
            root.right = note2;                         //         1   2
            note1.left = note3;                         //        / \   \
            note1.right = note4;                        //       3   4   5
            note2.right = note5;                        //      /     \
            note3.left = note6;                         //     6       7
            note6.left = note8;                         //    /
            note8.right = note9;                        //   8
            note4.right = note7;                        //    \
                                                        //     9

            System.out.println(burnTime(root, note7) + "s");  // 6s
            System.out.println(burnTime(root, note5) + "s");  // 7s
            System.out.println(burnTime(root, note9) + "s");  // 7s
        }

    }
    ```