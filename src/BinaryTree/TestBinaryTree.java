package BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binaryTree = new BinaryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋值给树
        binaryTree.setRoot(root);
        //再创建两个节点,一个右节点
        TreeNode rootR= new TreeNode(3);
        //把新创建的节点设置为根节点的右节点
        root.setrightNode(rootR);
        //左节点
        TreeNode rootL= new TreeNode(2);
        //把新创建的节点设置为根节点的左节点
        root.setLeftNode(rootL);
        //再创节点
        rootL.setrightNode(new TreeNode(5));
        rootL.setLeftNode(new TreeNode(4));
        //再创节点
        rootR.setrightNode(new TreeNode(7));
        rootR.setLeftNode(new TreeNode(6));
        //前序遍历
        binaryTree.frontShow();
        System.out.println("==============================");
        //中序遍历
        binaryTree.middleShow();
        System.out.println("==============================");
        //后序遍历
        binaryTree.afterShow();
        System.out.println("==============================");
        //前序查找
        TreeNode result = binaryTree.frontSearch(5);
        System.out.println(result);
        System.out.println("==============================");
        TreeNode result1 = binaryTree.frontSearch(8);
        System.out.println(result1);
        System.out.println("==============================");
        //删除节点
        binaryTree.delete(1);
        binaryTree.frontShow();
    }
}
