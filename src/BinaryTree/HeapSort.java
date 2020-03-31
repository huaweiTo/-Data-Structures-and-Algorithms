package BinaryTree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr =new int[]{9,6,8,7,0,1,10,4,2};
        System.out.println(Arrays.toString(arr));
        System.out.println("=========================================");
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr){
        //开始位置为最后一个节点的父节点
        int start=(arr.length-1)/2;
        //结束位置,数据的长度减一
        //调整为大顶堆
        for(int i=start;i>=0;i--) {
            maxHeap(arr, arr.length, i);
        }
        //先交换，再排序。。。
        for (int i=arr.length-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxHeap(arr,i,0);//去除最后一个数以后，结构变化，需要重新大顶堆调整,
            // 且因为只动了首尾，故索引1-length-2的数还是符合大顶堆的，我们只需要判断从尾部移到首部的数，即索引0
        }

    }

    /**
     *
     * @param arr
     * @param size 想要调整多少次
     * @param index 要调整哪一个(所用非叶子节点的索引）
     */
    public static void maxHeap(int[] arr,int size,int index){
        //左子节点
        int leftNode=2*index+1;//最后会越界，用size来判断
        //右子节点
        int rightNode=2*index+2;
        //和两个子节点分别对比，找出最大的节点
        int max=index;
        if(leftNode<size&&arr[leftNode]>arr[max]){
           max=leftNode;
        }
       if(rightNode<size&&arr[rightNode]>arr[max]) {
           max=rightNode;
       }
       //交换变量
        if(max!=index){
            int tmp=arr[index];
            arr[index]=arr[max];
            arr[max]=tmp;
            //交换位置以后可能会破坏之前拍好的堆，需要重新调整
            maxHeap(arr,size,max);
        }
    }
}
