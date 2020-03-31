package BinaryTree;

public class ThreadedBinaryTree {
    ThreadedNode root;
    //临时存取前驱节点
    ThreadedNode pre=null;
    //中序遍历
    public void threadIterate(){
        //用于临时存储当前遍历节点
        ThreadedNode node=root;
        while (node!=null){
            //循环找到最开始的节点
            while (node.leftType==0){//因为是中序，左根右，所以找左子节点，
                // 而且肯定不是线索指针，故type标记是0
                node=node.leftNode;
            }
            //打印当前节点的值
            System.out.println(node.value);
            //如果当前节点的右指针类型是type=1，即指向的是后继节点,
            // 在此后继节点之后还肯有后继节点，故循环找完所有后继节点
            while (node.rightType==1){//第一个while后找到最左下的节点，再往回找，
                // 只能用右边指针，但是因为是往回，即往上，指针类型必然是type=1,是0的话就往下了，他的右子节点
                node=node.rightNode;
                System.out.println(node.value);
            }
            node=node.rightNode;//上面找到后，没有后继节点了，打印出来，
            // 现在又得把他的右子节点赋给node，用于下一个循环(最外while),即替换遍历的节点
        }
    }
    //设置根节点
    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    //中序线索化二叉树
    public void threadNodes(){
        threadNodes(root);
    }

    public void threadNodes(ThreadedNode node){
        //当前节点如果null,直接返回
        if(node==null){
            return;
        }
        //处理左子树
        threadNodes(node.leftNode);
        if(node.leftNode==null){
            //让当前节点的左指针指向前驱节点
            node.leftNode=pre;
            //改变当前节点左指针的类型
            node.leftType=1;
        }
        //处理前驱节点的右指针，若前驱节点的右指针是null(即没有指下右子树)
        if(pre!=null&&pre.rightNode==null){//递归到第一个节点的时候(最下面左边)，
            // 他是最后一个，没有前驱节点了，所以不加判断pre!=null，会报空指针异常
            //让前驱节点的右指针指向当前节点
           pre.rightNode=node;
           //改变前驱节点的右指针类型
           pre.rightType=1;

        }
        //每处理一个节点，当前节点是下一个节点的前驱节点
        pre=node;
        //处理中间

        //处理右子树
        threadNodes(node.rightNode);

    }

    //获取根节点
    public ThreadedNode getRoot() {
        return root;
    }
    public void frontShow(){
        if(root!=null) {
            root.frontShow();
        }
    }

    public void middleShow() {
        if(root!=null) {
            root.middleShow();
        }
    }

    public void afterShow() {

        if(root!=null) {
            root.afterShow();
        }
    }

    public ThreadedNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    public void delete(int i) {
        if (root.value==i){
            root=null;
        }else {
            root.delete(i);
        }
    }
}
