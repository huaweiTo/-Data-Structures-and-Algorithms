package BinaryTree;

public class ArrayBinaryTree {
    int[] data;
    public ArrayBinaryTree(int[] data){
        this.data=data;
    }

    public void frontShow(){
       frontShow(0);
    }
    //前序遍历
    public void frontShow(int index) {//因为要传index，故重载一个方法不用传参数的
        //根节点的值打印一遍
        if(data==null||data.length==0){
            return;
        }
        //先遍历当前节点的内容
        System.out.println(data[index]);
        //2*index+1;处理左子树
        if(2*index+1<data.length){
            frontShow(2*index+1);
        }
        //2*index+2;处理右子树
        if(2*index+2<data.length){
            frontShow(2*index+2);
        }

    }
}
