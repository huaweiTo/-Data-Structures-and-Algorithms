package LineAndSort;

public class Test {
    public static void main(String[] args) {
        //测试栈
//        MyStack ms = new MyStack();
//        ms.push(9);
//        ms.push(8);
//        ms.push(7);
//        System.out.println(ms.peek());
//        int pop = ms.pop();
//        System.out.println(pop);
//        System.out.println(ms.peek());
//        System.out.println(ms.isEmpty());
        //测试队列
//        MyQueue mq = new MyQueue();
//        mq.add(9);
//        mq.add(8);
//        mq.add(7);
//
//        System.out.println(mq.poll());
//        System.out.println(mq.isEmpty());
//        System.out.println(mq.poll());
//        System.out.println(mq.isEmpty());
//        System.out.println(mq.poll());
//        System.out.println(mq.isEmpty());
//        System.out.println(mq.isEmpty());
        //测试单链表
//        Node n1=new Node(1);
//        Node n2=new Node(2);
//        Node n3=new Node(3);
//        n1.append(n3);
////        n1.append(n2);
//        n1.append(n2).append(n3).append(new Node(4));
//        System.out.println("展示-----------------");
//        //显示节点所有内容
//        n1.show();
//        System.out.println("添加---------------");
//        //插入一个新节点
//        Node node = new Node(5);
//        n1.next.after(node);
//        n1.show();
//        System.out.println("获取----------------");
//        System.out.println(n1.next().next().getData());
//        System.out.println("判断----------------");
//        //判断是否为最后一个节点
//        System.out.println(n1.isLast());
//        System.out.println(n1.next().next().next().isLast());
//        System.out.println("删除---------------");
//        //删除一个节点
//        n1.next().removeNext();
//        n1.show();


        //测试循环链表
//        System.out.println("循环链表---------------");
//        LoopNode n1=new LoopNode(1);
//        LoopNode n2=new LoopNode(2);
//        LoopNode n3=new LoopNode(3);
//        LoopNode n4=new LoopNode(4);
//        LoopNode n5=new LoopNode(5);
//        //增加节点
//        n1.after(n2);
//        n2.after(n3);
//        n3.after(n4);
//
//        System.out.println(n1.next().getData());
//        System.out.println(n2.next().getData());
//        System.out.println(n3.next().getData());
//        System.out.println(n4.next().getData());

        //测试双向链表
//        DoubleNode n1=new DoubleNode(1);
//        DoubleNode n2=new DoubleNode(2);
//        DoubleNode n3=new DoubleNode(3);
//
//        //查看上一个，自己，下一个节点的内容
//        System.out.println(n1.getPre().getData());
//        System.out.println(n1.getData());
//        System.out.println(n1.getNext().getData());
//        System.out.println("--------------------------------------");
//        //若是追加一个节点后，再显示上一个，自己，下一个的内容
//        n1.after(n2);
//        n2.after(n3);
//        System.out.println(n1.getPre().getData());
//        System.out.println(n1.getData());
//        System.out.println(n1.getNext().getData());
//        System.out.println(n2.getPre().getData());
//        System.out.println(n2.getData());
//        System.out.println(n2.getNext().getData());
//        System.out.println(n3.getPre().getData());
//        System.out.println(n3.getData());
//        System.out.println(n3.getNext().getData());
        for(int j=1;j<10;j++){
            System.out.println(++j);
        }
        System.out.println("-------------------------");
        for(int j=1;j<10;j++){
            System.out.println(j++);
        }

    }
}
