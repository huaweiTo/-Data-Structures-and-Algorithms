package LineAndSort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,8,5,9,1,0};
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------------------");
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
       //遍历所有的数字
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                int tmp=arr[i];
                //遍历当前数字前面的所有数字
                int j;
                for(j=i-1;j>=0&&tmp<arr[j];j--){
                    //把前一个数字赋值给后一个数字
                    arr[j+1]=arr[j];

                }
                //把临时变量赋值给不满足条件的后一个值
                arr[j+1]=tmp;

            }
        }
    }
}
