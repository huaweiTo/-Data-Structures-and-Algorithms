package LineAndSort;

import java.util.Arrays;

public class RadixQueueSort {
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
        //用于临时存储数据的队列的数组，即笔记里的方框
       MyQueue[] temp=new MyQueue[10] ;
       //为队列数组赋值
        for(int i=0;i<temp.length;i++){
            temp[i]=new MyQueue();
        }

        //根据最大长度的数决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把每一个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                int ys = arr[j] / n % 10;//余数
                //把当前遍历的数据放入指定的队列中
                temp[ys].add(arr[j]);

                //不用记录数量了，因为队列是先进先出的
//                //记录数量
//                counts[ys]++;
            }

            //以上把数组放进去,接着把数据取出来
            //记录取得元素要放的位置
            int index=0;
            for(int k=0;k<temp.length;k++){
                //记录数量的数组中当前余数不为0，则取
                   //循环取出元素
                while (!temp[k].isEmpty()) {
                    //取出元素
                    arr[index] = temp[k].poll();
                    index++;
                }
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
