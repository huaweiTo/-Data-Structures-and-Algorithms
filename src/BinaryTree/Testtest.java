package BinaryTree;

import java.util.Arrays;

public class Testtest {
    public void c(int[] b){
       int[] newb =new int[b.length] ;
       for (int i=0;i<b.length;i++){
           newb[i]=b[i];
       }
       newb[0]=1;

    }

    public static void main(String[] args) {
        Testtest aa= new Testtest();
        int[] b=new int[]{5,5,5};
        System.out.println(Arrays.toString(b));
        System.out.println("===================================");
        aa.c(b);
        System.out.println(Arrays.toString(b));
//        for(int bb:b){
//            System.out.println(bb);
//        }
    }
}
