package LineAndSort;
public class MyQueue {
    int[] elements;
    public MyQueue(){
        elements = new int[0];
    }
    //入队
    public void add(int element){
        int[] newArr = new int[elements.length+1];
        for(int i=0;i<elements.length;i++){
            newArr[i] = elements[i];
        }
       newArr[elements.length] = element;
        elements = newArr;
    }
    //出队
    public int poll(){
       //取出数组中第0个元素
        int element = elements[0];
        int[] newArr = new int[elements.length-1];
        for (int i=1;i<elements.length;i++){
            newArr[i-1] = elements[i];
        }
        elements = newArr;
        return element;
    }
    public boolean isEmpty(){
        return elements.length==0;
    }
}
