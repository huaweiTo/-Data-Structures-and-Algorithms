package LineAndSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int [] {5,7,2,9,4,1,0,5,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------");
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        //控制共比较多少轮
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){//控制两两相比的次数
               if(arr[j]>arr[j+1]) {
                   int tmp = arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=tmp;
               }
            }
        }
    }
}
