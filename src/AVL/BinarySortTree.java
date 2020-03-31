package AVL;

public class BinarySortTree {
    Node root;

    /**
     * 向二叉排序树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        //若是一个空的节点
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }

    }

    /**
     * 中序遍历二叉排序树，刚好是从小到大
     */
    public void middleShow() {
        if (root != null) {
            root.middleShow(root);
        }
    }

    /**
     * 节点的查找
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 删除节点
     * @param value
     */
    public void delete(int value){
       if(root==null) {
           return;
       }else {
           //找到这个节点
           Node target = search(value);
           //若没有
           if(target==null){
               return;
           }
           //找到他的父节点
           Node parent=searchParent(value);
           //要删除的节点是叶子节点-----------------------------------------------------1.
           if(target.left==null&&target.right==null){
               //要删除的节点是父节点的左节点
               if(parent.left.value==value){
                   parent.left=null;
                   //要删除的节点是父节点的右节点
               }else {
                   parent.right=null;
               }
          //要删除的节点有2个子节点-------------------------------------------------------2.
           }else if(target.left!=null&&target.right!=null){
               //删除右子树中值最小的节点，则获取到该节点的值
               int min =deleteMin(target.right);
               //替换目标节点中的值
               target.value=min;

         //要删除的节点有一个左子节点或者右子节点-----------------------------------------3.
           }else {
               //有左子节点=======
               if(target.left!=null){
                   //要删除的节点是父节点的左子节点
                   if(parent.left.value==value){
                       parent.left=target.left;
                       //要删除的节点是父节点的右子节点
                   }else {
                       parent.right=target.left;
                   }

              //有右子节点========
               }else {
                   //要删除的节点是父节点的左子节点
                   if(parent.left.value==value){
                       parent.left=target.right;
                       //要删除的节点是父节点的右子节点
                   }else {
                       parent.right=target.right;
                   }

               }

           }
       }
    }

    /**
     * 删除一棵树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target=node;
        while (target.left!=null){
            target=target.left;
        }
        delete(target.value);//下面的节点会自动补上去，delete方法里1.,2.已经实现
        return target.value;

    }

    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public Node searchParent(int value){
        if(root==null){
            return null;
        }else {
            return root.searchParent(value);
        }

    }
}
