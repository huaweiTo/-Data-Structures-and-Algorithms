package HuffmanCode;

import java.security.Key;
import java.util.*;

public class TestHuffmanCode {
    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can.";
        //因为所有数据最终都可以转换为一个byte数组，
        // 且后面可能要进行文件的压缩,文件读取出来也是一个byte数组，故转化为byte
        byte[] bytes = msg.getBytes();
        //进行赫夫曼编
        byte[] b = huffmanZip(bytes);
//        System.out.println(bytes.length);//看看编码前后的长度差距
//        System.out.println(b.length);
        //使用霍夫曼编码进行解码
        byte[] newBytes=decode(huffCodes,b);
        //下面两个输出对比一样说明解码成功
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Arrays.toString(newBytes));
        System.out.println(new String(newBytes));
    }

    /**
     * 使用指定的霍夫曼编码表进行解码
     * @param huffCodes2
     * @param bytes
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffCodes2, byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        //1.把byte在数组转为二进制的字符串
        for(int i=0;i<bytes.length;i++){
            //是否是最后一个
            boolean flag=(i==bytes.length-1);
            byte b=bytes[i];
            sb.append(byteToBitStr(!flag,b));
        }
        //2.把字符串按照指定的赫夫曼编码进行解码
        //把赫夫曼编码的键值对进行调换,因为没有用值去找键的方法，我们现在有了值，调换，就能找到键了
        Map<String,Byte> map=new HashMap<>();
        for(Map.Entry<Byte,String> entry:huffCodes.entrySet()){
           map.put(entry.getValue(),entry.getKey());
        }
        //创建一个集合，用于存byte
        List<Byte> list=new ArrayList<>();
        //处理字符串
        for (int i=0;i<sb.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;
            //截取出一个byte
            while (flag){
                String key=sb.substring(i,i+count);
                b=map.get(key);
                if(b==null){
                    count++;
                }else {
                    flag=false;
                }
            }
//            System.out.println(b);
            list.add(b);
            i+=count;
        }
//        System.out.println(list);
        //把集合转为数组就ok
        byte[] b= new byte[list.size()];
        for (int i=0;i<b.length;i++){
           b[i]=list.get(i) ;
        }
        return b;
    }

    /**
     * 将byte转为二进制字符
     * @param flag
     * @param b
     * @return
     */
    public static String byteToBitStr(boolean flag,byte b){
        //用flag来指示是不是最后一个，因为最后一个可能长度不为8，我们要是还弄成8就会比原来长了
        int temp=b;//例如b=1,则byte为1，我们需要前面补足7个0，使成为8位
        if(flag){
            temp|=256;//和256或一下，前面就有数了，不光是1了，
        }
        String str=Integer.toBinaryString(temp);//这个方法默认用的是int类型，所以二进制出来长32位
        if(flag){
            return str.substring(str.length()-8);//从倒数第8位取，取最后8位
        }else {
            return str;
        }

    }

    /**
     * 进行赫夫曼编码压缩的方法
     *
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //1.统计出每一个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);//为了代码不过与多，写成方法
        //2.创建一个赫夫曼树
        Node tree = createHuffmanTree(nodes);
//        System.out.println(tree);
        //3.创建一个赫夫曼编码表
        Map<Byte, String> huffCodes = getCodes(tree);
//        System.out.println(huffCodes);
        //4.编码
        byte[] b = zip(bytes, huffCodes);
        return b;
    }

    /**
     * 进行霍夫曼编码
     *
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        //因为要拼在一起,新建一个stringbuilder
        StringBuilder sb = new StringBuilder();
        //把需要压缩的byte数组处理成一个二进制的字符串
        for(byte b:bytes){
            sb.append(huffCodes.get(b));
        }
//        System.out.println(sb.toString());
        //接着把这个二进制字符串转成数组，因为返回的是数组，每8位转成一个数组
        //定义长度
        int len;
        if(sb.length()%8==0){
            len=sb.length()/8;
        }else {
            len=sb.length()/8+1;
        }
        //用于存储压缩后的byte
        byte[] by=new byte[len];
        //记录新的byte的位置
        int index=0;
        for (int i=0;i<sb.length();i+=8){
            String strByte;
            if(i+8>sb.length()){
                strByte=sb.substring(i,sb.length());
            }else {
                strByte = sb.substring(i, i + 8);
            }
//            System.out.println(strByte);
            byte byt=(byte)Integer.parseInt(strByte,2);
//            System.out.println(strByte+":"+byt);
            by[index] = byt;
            index++;

        }
        return by;
    }

    //因为要递归（每个节点经过，都会留下一个0或1），所以要临时存一下路劲
    static StringBuilder sb = new StringBuilder();
    //用于存储霍夫曼编码
    static Map<Byte, String> huffCodes = new HashMap<>();

    /**
     * 根据霍夫曼树获取霍夫曼编码
     *
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {
        if (tree == null) {
            return null;
        }
        getCodes(tree.left, "0", sb);//向左给0
        getCodes(tree.right, "1", sb);//向右给1
        return huffCodes;
    }

    /**
     * @param node
     * @param code
     * @param sb
     */
    private static void getCodes(Node node, String code, StringBuilder sb) {
        //创建一个新的StringBuilder，调用上一个的结果
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data == null) {//内容为空，说明不是叶节点，因为霍夫曼树里面除了叶节点外，其他的我们都只给了权重，没有给内容
            getCodes(node.left, "0", sb2);
            getCodes(node.right, "1", sb2);
        } else {
            huffCodes.put(node.data, sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     *
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
//            System.out.println(nodes);
            //取出权值最低的两个二叉树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            //创一个新的二叉树
            Node parent = new Node(null, left.weight + right.weight);
            //把之前取出的两颗二叉树设置为新创建的二叉树的子树
            parent.left = left;
            parent.right = right;
            //把 前面取出的两颗二叉树删除
            nodes.remove(left);
            nodes.remove(right);
            //把新创建的二叉树放入集合
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转为Node集合
     *
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        //存储每一个byte出现了多少次
        Map<Byte, Integer> counts = new HashMap<>();
        //统计每一个byte出现的次数
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //把每一个键值对转为一个node对象
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
//        System.out.println(counts);
        //结果为：{32=11, 97=11, 114=1, 99=7, 115=1, 117=1, 101=1, 121=1, 110=8, 46=1, 111=1}
        //32为空格
        return nodes;
    }
}
