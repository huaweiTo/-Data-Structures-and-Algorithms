package LineAndSort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,7,8,1,2,0,4,7,4,3,8};
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------------------");
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){
       //遍历所有的步长（增量）
        int k=1;
        for(int d=arr.length/2;d>0;d/=2){//轮数
            //遍历所有元素
            for(int i=d;i<arr.length;i++){//用i++，就是把后面所有的元素都取到，感觉i+=d也行
                //遍历本组中的所有数字
                for(int j=i-d;j>=0;j-=d){
                   if(arr[j]>arr[j+d]){
                       int tmp=arr[j];
                       arr[j]=arr[j+d];
                       arr[j+d]=tmp;
                   }
                }

            }
            System.out.println("第"+k+"次排序结果"+Arrays.toString(arr));
            k++;
        }
    }
}
