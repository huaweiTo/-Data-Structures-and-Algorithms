package BinaryTree;

public class Node implements Comparable<Node> {
    int value;
    Node leftNode;
    Node rightNode;
    public Node(int value){
       this.value=value;
    }

    @Override
    public int compareTo(Node node) {
//        return this.value-node.value;//从小到大
        return -(this.value-node.value);//从大到小
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
