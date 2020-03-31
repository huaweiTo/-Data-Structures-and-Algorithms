package AVL;

public class TestBinarySortTree {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6,7,8};
//        int[] arr = new int[]{8,9,6,7,5,4};//测试右旋转
//        int[] arr = new int[]{2,1,4,3,5,6};//测试左旋转
        int[] arr = new int[]{8, 9, 5, 4, 6, 7};//测试双旋转
        //创建一颗二叉排序树
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环添加
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        //查看高度
        System.out.println(binarySortTree.root.height());
        System.out.println(binarySortTree.root.value);

    }

}
