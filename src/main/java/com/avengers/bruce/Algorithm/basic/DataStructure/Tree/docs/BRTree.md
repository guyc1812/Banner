# BR Tree

![brtree](http://guyuchen.com/deadpool/images/brtree.png)

## 节点结构

```java
public class BRNode <T extends Comparable<T>>{

    boolean color;
    T key;
    BRNode<T> left;
    BRNode<T> right;
    BRNode<T> parent;

    public BRNode(boolean color, T key, BRNode<T> left, BRNode<T> right, BRNode<T> parent) {
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return key + " " + (this.color? "R" : "B");
    }
}
```

## 性质

1. 每个结点是红的，或是黑的；
1. 根结点是黑的；
1. 每个叶结点（NIL）是黑的；
1. 如果一个结点是红的，则它的两个儿子都是黑的；
1. 对每个结点，从该结点到其子孙结点的所有路径上包含相同数目的黑结点。”

也即：<br>
要么红，要么黑；<br>
一头一尾都是黑；<br>
有红必有黑；<br>
任意路径上黑结点个数稳定。

## 证明：

一棵有n个内结点的红黑树的高度至多为2lg(n+1), 即 BRT 的时间复杂度为 O(lgn)
```
首先证明： x 所在 BR-Tree 内所有节点个数至少为 2^bh(x) - 1

定义说明：
① 黑高度，结点 x 到达它任意一个叶节点的路径上所有黑色节点的个数
② 黑高度 不包括节点x自身

1. 若 x 为叶节点， bh(x) = 0, ==> 2^0- 1 = 0
2. 若 x 非叶节点， bh(x) > 0
   对于其子节点：
        若为红，则该子节点的黑高度为 bh(x)
        若为黑，则该子节点的黑高度为 bh(x)-1
   
所以 x 所在 BR-Tree 内所有节点个数 n 至少为 2 * (2^(bh(x)-1)-1) + 1 = 2bh(x) - 1

理解：对于一棵 BRT, 根节点到达任意叶节点所经过的黑节点数相同，若以黑节点为叶，则为一棵高为 bh(x) 的完全二叉树

其次：根据 BRT 的性质，有红必有黑，所以黑节点的个数至少是红节点的2倍，即黑高度至少为 h/2

所以 bh(x) >= h/2

n >= 2^(2/h) - 1
h <= 2lg(n+1)
```

## 插入

* **黑父**

    如果新节点的父结点为黑色结点，那么插入一个红点将不会影响红黑树的平衡，此时插入操作完成。<br>
    红黑树比AVL树优秀的地方之一在于黑父的情况比较常见，从而使红黑树需要旋转的几率相对AVL树来说会少一些。
  
    ![image](http://guyuchen.com/deadpool/images/br1.jpg)
  
* **红父**
  
    如果新节点的父结点为红色，这时就需要进行一系列操作以保证整棵树红黑性质。<br>
    如下图所示，由于父结点为红色，此时可以判定，祖父结点必定为黑色。<br>
    这时需要根据叔父结点的颜色来决定做什么样的操作。<br>
    青色结点表示颜色未知。由于有可能需要根结点到新点的路径上进行多次旋转操作，而每次进行不平衡判断的起始点都不一样。<br>
    所以我们在此使用一个蓝色箭头指向这个起始点，并称之为判定点。
  
    ![image](http://guyuchen.com/deadpool/images/br2.jpg)
    
    * **红叔**
    
        当叔父结点为红色时，如下图所示，无需进行旋转操作，只要将父和叔结点变为黑色，将祖父结点变为红色即可。
        但由于祖父结点的父结点有可能为红色，从而违反红黑树性质。
        此时必须将祖父结点作为新的判定点继续向上（迭代）进行平衡操作。（注意这里是需要迭代的，有可能会调整到根节点）
        
        ![image](http://guyuchen.com/deadpool/images/br2-1.jpg)
        
        需要注意的是，无论“父节点”在“叔节点”的左边还是右边，无论“新节点”是“父节点”的左孩子还是右孩子，它们的操作都是完全一样的（其实这种情况包括4种，只需调整颜色，不需要旋转树形）。
        
    * **黑叔**
    
        当叔父结点为黑色时，需要进行旋转，以下图示了所有的旋转可能：（case1 和caes 2 都是把左边较大的节点调整到上面去）
        
        1. ![image](http://guyuchen.com/deadpool/images/br2-2-1.jpg)
        1. ![image](http://guyuchen.com/deadpool/images/br2-2-2.jpg)
        1. ![image](http://guyuchen.com/deadpool/images/br2-2-3.jpg)
        1. ![image](http://guyuchen.com/deadpool/images/br2-2-4.jpg)
        
  
## 如何扩张数据结构

对一种数据结构的扩张过程分为四个步骤：
   
1. 选择基础数据结构   
1. 确定要在基础数据结构中添加哪些信息
1. 验证可用基础数据结构上的基本修改操作来维护这些新添加的信息
1. 设计新的操作
  
## 序统计树

```java
public class BRNode <T extends Comparable<T>>{

    boolean color;
    T key;
    BRNode<T> left;
    BRNode<T> right;
    BRNode<T> parent;
    
    int size;

}
```

![image](http://guyuchen.com/deadpool/images/sizeTree.png)


## 区间树

![image](http://guyuchen.com/deadpool/images/rangeTree.png)
