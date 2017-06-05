## 树的一些基本概念  
1. LL 型：表示在左孩子的左子树插入节点导致的失衡情况  
2. LR 型：表示在左孩子的右子树插入节点导致的失衡情况  
3. RR 型：表示在右孩子的右子树插入节点导致的失衡情况  
4. RL 型：表示在右孩子的左子树插入节点导致的失衡情况  
#### 对应的操作：  
1. LL 型：右旋  
2. LR 型：先左旋，后右旋(双旋)  
3. RR 型：左旋  
4. RL 型：先右旋，后左旋(双旋)  