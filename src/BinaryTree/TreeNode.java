package BinaryTree;

public class TreeNode {
    //节点的权
    int value;
    //左儿子
    TreeNode leftNode;
    //右儿子
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    //设置左儿子
    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    //设置右儿子
    public void setrightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //前序
    public void frontShow() {
        //先遍历当前节点的内容
        System.out.println(value);
        //左节点
        if (leftNode != null) {
            leftNode.frontShow();
        }
        //右节点
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    //中序
    public void middleShow() {
        if (leftNode != null) {
            leftNode.middleShow();
        }
        System.out.println(value);

        if (rightNode != null) {
            rightNode.middleShow();
        }
    }

    //后序
    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }

        if (rightNode != null) {
            rightNode.afterShow();
        }

        System.out.println(value);
    }

    //前序查找
    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        //对比当前节点
        if (this.value == i) {
            return this;
        } else {
            //当前节点的值不是要查找的节点
            //查找左儿子
            if (leftNode != null) {
                target = leftNode.frontSearch(i);
            }

            //若target不为空，说明已经在左儿子中找到
            if (target != null) {
                return target;
            }
            //查找右儿子
            if (rightNode != null) {
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }

    //删除一个子树
    public void delete(int i) {
        //判断左儿子
        if(leftNode!=null&&leftNode.value==i){
            leftNode=null;
            return;
        }
        //判断右儿子
        if(rightNode!=null&&rightNode.value==i){
            rightNode=null;
            return;
        }
        //递归检查并删除左儿子
        if(leftNode!=null){
            leftNode.delete(i);
        }
        //递归检查并删除右儿子
        if(rightNode!=null){
            rightNode.delete(i);
        }
    }
//    //删除一个子树
//    public void delete(int i) {
//        TreeNode parent=this;//因为是链表，过来以后就不能指向了
//        //判断左儿子
//        if(parent.leftNode!=null&&parent.leftNode.value==i){
//            parent.leftNode=null;
//            return;
//        }
//        //判断右儿子
//        if(parent.rightNode!=null&&parent.rightNode.value==i){
//            parent.rightNode=null;
//            return;
//        }
//        //递归检查并删除左儿子
//        parent=leftNode;
//        if(parent!=null){
//            parent.delete(i);
//        }
//        //递归检查并删除右儿子
//        parent=rightNode;
//        if(parent!=null){
//            parent.delete(i);
//        }
//    }

}
