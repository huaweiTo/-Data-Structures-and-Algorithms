package BinarySortTree;

public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        //创建一颗二叉排序树
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环添加
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        //显示,中序
        binarySortTree.middleShow();
        //查找
        Node node = binarySortTree.search(10);
        System.out.println(node.value);
        Node node1 = binarySortTree.search(20);
        System.out.println(node1);//这里不是用node1.value是因为根本没有node1，所以写value会空指针异常
        //查找父节点
        Node p1 = binarySortTree.searchParent(10);
        System.out.println(p1.value);

        System.out.println("=========================");
        //删除叶子节点
        binarySortTree.delete(5);
        binarySortTree.middleShow();
        System.out.println("=========================");
        //删除只有一个子节点的节点
        binarySortTree.delete(3);
        binarySortTree.middleShow();
        System.out.println("=========================");
        //删除有两个子节点的节点
        binarySortTree.delete(7);
        binarySortTree.middleShow();
    }

}
