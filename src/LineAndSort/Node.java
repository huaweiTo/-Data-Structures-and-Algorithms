package LineAndSort;
//一个节点
public class Node {
     //节点内容
    int data;
    //下一个节点
    Node next;

    public Node(int data){
        this.data=data;
    }
//为节点追回节点
    public Node append(Node node){

        //像找火车车尾，你知道车头，要一直往后才能找到车尾
        Node currentNode = this;
        //循环向后找
        while(true){
            Node nextNode = currentNode.next;
            //如果没有下一个节点，即为NULL，停止
            if (nextNode==null){
                break;
            }
            //下一个节点赋值给当前节点
            currentNode = nextNode;
        }
        //把需要追加的节点追加到找到的当前节点的下一个节点
        currentNode.next=node;
        return this;
//        this.next = node;//简单下一个
    }
    //删除下一个节点
    public void removeNext(){
        //先取出下下一个节点
        Node newNext = next.next;
        //把下下一个节点设置为当前节点的下一个节点
        this.next= newNext;
    }
    //显示所有节点信息
    public void show(){
        Node currentNode=this;
        while(true){
            System.out.println(currentNode.data+" ");
            //取出下一个节点
            currentNode=currentNode.next;
            //如果是最后一个节点的话
            if (currentNode.next==null){
                break;
            }
        }
    }
    //插入一个节点,单链表只能插在后面，不能前面
    public void after(Node node){

        //取出下一个节点，作为下下个节点
        Node nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next=node;
        //把下下一个节点设置为新节点的下一个节点
        node.next=nextNext;
    }
    //获取下一个节点
    public Node next(){
        return this.next;
    }
    //获取节点中的数据
     public int getData(){
       return this.data;
     }
     public boolean isLast(){
        return next==null;
     }
}

