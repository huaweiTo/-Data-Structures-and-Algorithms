package AVL;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 获得当前节点的高度差
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 获取左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 获取右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 向子树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值比当前子树的根节点的值大还是小
        //添加的节点比当前节点的值更小
        if (node.value < this.value) {
            //若左节点为空
            if (this.left == null) {
                this.left = node;
                //若不为空
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //检查是否平衡，即我们得知道左子树和右子树的高度
        //右旋转
        if (leftHeight() - rightHeight() >= 2) {
            //双旋转
            if (left.leftHeight() < left.rightHeight()) {
                left.leftRotate();//把左边节点旋转
                //再右旋转
                rightRotate();
            //单旋转
            } else {
                rightRotate();
            }

        }
        //右旋转
        if (leftHeight() - rightHeight() <= -2) {
            //双旋转
            if (right.rightHeight() < right.leftHeight()) {
                right.rightRotate();//把右边节点旋转
                //再左旋转
                leftRotate();

            } else {
                //单旋转
                leftRotate();
            }
        }
    }

    /**
     * 右旋转
     */
    private void rightRotate() {
        //例子里，先拿出8，9变8的右，7变8的左，6变到8原来的位置，5和4往上移，现在的8放到现在6的右
        //1.创建一个新节点，值等于当前节点的值
        Node newright = new Node(value);
        //2.新节点的右子节点设置为当前节点的右子节点
        newright.right = right;
        //3.把新节点的左子树设置为当前节点的左子树的右子树
        newright.left = left.right;
        //把当前节点的值换成左子节点的值
        value = left.value;
        //把当前节点的左子树设置为左子树的左子树
        left = left.left;
        //把当前节点的右子树设置为新节点
        right = newright;

    }

    /**
     * 左旋转
     */
    private void leftRotate() {
        //同右旋转
        //1.创建一个新节点，值等于当前节点的值
        Node newleft = new Node(value);
        //2.新节点的右子节点设置为当前节点的右子节点
        newleft.left = left;
        //3.把新节点的左子树设置为当前节点的左子树的右子树
        newleft.right = right.left;
        //把当前节点的值换成左子节点的值
        value = right.value;
        //把当前节点的左子树设置为左子树的左子树
        right = right.right;
        //把当前节点的右子树设置为新节点
        left = newleft;

    }

    /**
     * 中序遍历二叉排序树，刚好是从小到大
     *
     * @param node
     */
    public void middleShow(Node node) {
        if (node == null) {
            return;
        }
        middleShow(node.left);
        System.out.println(node.value);
        middleShow(node.right);

    }

    /**
     * 查找节点
     *
     * @param value
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            if (left == null) {
                return null;
            }
            return left.search(value);
        } else {
            if (right == null) {
                return null;
            }
            return right.search(value);
        }
    }

    /**
     * 搜索父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (this.left != null && this.left.value == value || this.right != null && this.right.value == value) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value < value && this.right != null) {
                return this.right.searchParent(value);
            }
        }
        return null;
    }


}
