package LineAndSort;
public class DoubleNode {
    //上一个节点
    DoubleNode pre = this;//创建一个的时候，前一个是自己
    //下一个节点
    DoubleNode next= this;//创建一个的时候，后一个是自己
    //节点数据
    int data;
    public DoubleNode(int data){
        this.data=data;
    }
    //增加节点
    public void after(DoubleNode node){
        //原来的下一个节点
        DoubleNode nextNext=this.next;
//        DoubleNode nextNext=next; //和上一句作用一样
        //把新节点作为当前节点的下一个节点
        this.next=node;
        //把当前节点作为新节点的前一个节点
        node.pre=this;
        //把原来的下一个节点作为新节点的下一个节点
        node.next=nextNext;
        //把新节点作为原来的下一个节点的前一个节点
        nextNext.pre=node;

    }
    //获取下一个节点
    public DoubleNode getNext(){
        return this.next;
    }
    //获取上一个节点
    public DoubleNode getPre(){
        return this.pre;
    }
    //获取数据
    public int getData(){
        return this.data;
    }
}
