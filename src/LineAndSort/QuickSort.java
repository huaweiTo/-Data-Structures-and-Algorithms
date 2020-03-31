package LineAndSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr = new int[]{3,4,6,7,2,7,2,8,0};
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------------------");
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int start, int end){
        if(start<end) {//没有这个判断，程序不知道什么时候结束，会溢出
            //把数组中第0个数作为标准数
            int stand = arr[start];
            //设置两个坐标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                //从高的开始 ,循环找比标准数大
                while (low < high && stand <= arr[high]) {
                    high--;
                }
                //右边的数替换左边的
                arr[low] = arr[high];
                //从低的开始 ,循环找比标准数小
                while (low < high && stand >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }

            arr[low] = stand;
//        arr[high]=stand;//和上面一句一样，任选，因为low和high已经相等
            //使用同样方式再排，即使用递归
            //处理所有的比标准数小的
            quickSort(arr, start, low);
            //处理所有的比标准数大的
            quickSort(arr, low + 1, end);
        }
    }
}
