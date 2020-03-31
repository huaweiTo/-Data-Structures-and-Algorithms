package BinaryTree;

public class TestThreadedBinaryTree {
    public static void main(String[] args) {
        //创建一棵树
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        //创建一个根节点
        ThreadedNode root = new ThreadedNode(1);
        //把根节点赋值给树
        threadedBinaryTree.setRoot(root);
        //再创建两个节点,一个右节点
        ThreadedNode rootR= new ThreadedNode(3);
        //把新创建的节点设置为根节点的右节点
        root.setrightNode(rootR);
        //左节点
        ThreadedNode rootL= new ThreadedNode(2);
        //把新创建的节点设置为根节点的左节点
        root.setLeftNode(rootL);
        //再创节点
        ThreadedNode fiveNode =new ThreadedNode(5);
        rootL.setrightNode(fiveNode);
        rootL.setLeftNode(new ThreadedNode(4));
        //再创节点
        rootR.setrightNode(new ThreadedNode(7));
        rootR.setLeftNode(new ThreadedNode(6));
        //前序遍历
        threadedBinaryTree.frontShow();
        System.out.println("============前序遍历==================");
        //中序遍历
        threadedBinaryTree.middleShow();
        System.out.println("============中序遍历==================");
        //后序遍历
        threadedBinaryTree.afterShow();
        System.out.println("============后序遍历==================");
        //前序查找
        ThreadedNode result = threadedBinaryTree.frontSearch(5);
        System.out.println(result);
        ThreadedNode result1 = threadedBinaryTree.frontSearch(8);
        System.out.println(result1);
        System.out.println("=============前序查找=================");
        //删除节点
//        threadedBinaryTree.delete(1);
//        threadedBinaryTree.frontShow();
//        System.out.println("=============删除=================");


        //中序遍历
        threadedBinaryTree.middleShow();
        System.out.println("============中序遍历==================");
        //中序线索化二叉树
        threadedBinaryTree.threadNodes();
        System.out.println("=============中序线索化二叉树=================");

        //判断一下,看看5后面是不是1
//        ThreadedNode afterFive = fiveNode.rightNode;
//        System.out.println(afterFive.value);
        //中序遍历
        threadedBinaryTree.threadIterate();
        System.out.println("=============中序遍历=========================");

    }
}
