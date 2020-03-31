package LineAndSort;

import java.sql.SQLOutput;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 6, 189, 45, 9, 287, 56, 1, 798, 34, 65, 652, 5};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------------");
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //存数组中的最大的数字
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //计算最大数字是几位数
        int maxLength = (max + "").length();//max加上""后九城了字符串类型，,从而可以知道是几位数
        System.out.println(maxLength);
        //用于临时存储数据的数组，即笔记里的方框
        int[][] temp = new int[10][arr.length];
        //用于记录在相应的数组中存放的数字的数量
        int[] counts = new int[10];
        //根据最大长度的数决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把每一个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                int ys = arr[j] / n % 10;//余数
                temp[ys][counts[ys]]=arr[j];
                //记录数量
                counts[ys]++;
            }

            //以上把数组放进去,接着把数据取出来
            //记录取得元素要放的位置
            int index=0;
            for(int k=0;k<counts.length;k++){
                //记录数量的数组中当前余数不为0，则取
               if(counts[k] !=0){
                   //循环取出元素
                   for(int l=0;l<counts[k];l++){
                      //取出元素
                      arr[index]= temp[k][l];
                      index++;
                   }
                   //把数量置空
                   counts[k]=0;
               }
            }
//            if(i==0){
//                for(int[] nums:temp){
//                    System.out.println(Arrays.toString(nums));
//                }
//                System.out.println(Arrays.toString(counts));
//            }

        }
    }
}
