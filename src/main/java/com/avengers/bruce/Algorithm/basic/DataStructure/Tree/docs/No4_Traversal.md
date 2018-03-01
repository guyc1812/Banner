# Traversal of Tree

* **Traversal by recursion**

    ```java
    private static void preOrderByRecur(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrderByRecur(node.left);
        preOrderByRecur(node.right);
    }
    ```
    
    ```java    
    private static void inOrderByRecur(TreeNode node) {
        if (node == null) return;
        inOrderByRecur(node.left);
        System.out.print(node.val + " ");
        inOrderByRecur(node.right);
    }
    ```
    
    ```java
    private static void postOrderByRecur(TreeNode node) {
        if (node == null) return;
        postOrderByRecur(node.left);
        postOrderByRecur(node.right);
        System.out.print(node.val + " ");
    }
    ```
    
* **Traversal by iteration**

    ```java
    private static void preOrderByIteration(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right; //if null，pop next and deal with the right child
        }

        result.forEach(e -> System.out.print(e + " "));
    }
    ```
    
    ```java
    private static void inOrderByIteration(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            result.add(root.val);
            root = root.right; //if null，pop next and deal with the right child
        }

        result.forEach(e -> System.out.print(e + " "));
    }
    ```
    
    ```java
    private static void postOrderByIteration(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        stack.push(root);                //push root first  
        while (!stack.isEmpty()) {
            TreeNode ele = stack.pop();   
            if (ele.left != null)
                stack.push(ele.left);  
            if (ele.right != null) {
                stack.push(ele.right); 
            }
            result.add(0, ele.val); //add at 0 position 
        }
        
        result.forEach(e -> System.out.print(e + " "));
    }
    ```
    
* **Traversal by level**
    
    ```java
    private static void levelTravel(TreeNode root) {
    
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
      
        q.add(root);
      
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }

    }
    ```

* **Test**

    ```java
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        System.out.println("\nPreOrder Traversal of binary tree is ");
        preOrderByRecursion(root);
        System.out.print("\n");
        preOrderByIteration(root);

        System.out.println("\nInOrder Traversal of binary tree is ");
        inOrderByRecursion(root);
        System.out.print("\n");
        inOrderByIteration(root);

        System.out.println("\nPostOrder Traversal of binary tree is ");
        postOrderByRecursion(root);
        System.out.print("\n");
        postOrderByIteration(root);

        System.out.println("\nLevel Traversal of binary tree is ");
        levelTravel(root);

        System.out.print("\n");

    }
    
    // PreOrder Traversal of binary tree is 
    // 1 2 4 5 7 3 6 
    // 1 2 4 5 7 3 6 
    // InOrder Traversal of binary tree is 
    // 4 2 7 5 1 3 6 
    // 4 2 7 5 1 3 6 
    // PostOrder Traversal of binary tree is 
    // 4 7 5 2 6 3 1 
    // 4 7 5 2 6 3 1 
    // Level Traversal of binary tree is 
    // 1 2 3 4 5 6 7 
    ```
