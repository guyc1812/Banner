# Depth of Tree

* **Max depth**

    ```java
    private static int maxDepth(TreeNode node) {
    
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }
    ```

* **Min depth**

    ```java
    private static int minDepth(TreeNode root) {
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
        int left = getMin(root.left);
        int right = getMin(root.right);
        return Math.min(left, right) + 1;
    }
    ```

* **Test**

    ```java
    public static void main(String[] args) {
    
        TreeNode node = new TreeNode();
        TreeNode root = node.getTree();
    
        int maxD = maxDepth(root);
        int minD = minDepth(root);
    
        System.out.println("min depth: " + minD);
        System.out.println("max depth: " + maxD);
    
    }
    
    // min depth: 3
    // max depth: 4
    ```