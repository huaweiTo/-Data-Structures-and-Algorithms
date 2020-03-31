package LineAndSort;

public class TestHanoi {
    public static void main(String[] args) {
        hanoi(5,'A','B','C');

    }

    /**
     *
     * @param n 共有n个盘子
     * @param from 开始的柱子
     * @param in 中间的柱子
     * @param to 目标柱子
     *           无论多少个盘子，都认为只有两个，上面的所有盘子、最下面的一个盘子
     */
    public static void hanoi(int n, char from, char in, char to){
       if(n==1){
           System.out.println("把第一个盘子从"+from+"移到"+to);
       }else {
           //移动上面的所有盘子到中间位置
           hanoi(n-1,from,to,in);//先移到中间,故目标变成了原来的中间，原来的中间变成了目标
           //移动最下面的盘子
           System.out.println("把第"+n+"个盘子从"+from+"移到"+to);
           //把上面的所有盘子从中间位置移动到目标位置
           hanoi(n-1,in,from,to);

       }
    }
}
