# Balanced Tree

* **If balanced**

    ```java
    private static boolean isBalance = true;
    ```
    
    ```java
    private static boolean isBalanced(TreeNode root) {
        treeDepth(root);
        return isBalance;   //isBalance will change in treeDepth(root)
    }
    ```
    
    ```java
    static private int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);      //depth of left child
        int right = treeDepth(root.right);    //depth of left child
    
        if (Math.abs(left - right) > 1) isBalance = false;
    
        return Math.max(left, right) + 1;
    }
    ```

* **Test**

    ```java
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        TreeNode root = node.getTree();
        Boolean balance = isBalanced(root);
        System.out.println(balance);
    }
    
    // false
  
    ```