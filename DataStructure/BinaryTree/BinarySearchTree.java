/**
 * 二叉搜索树
 * https://www.cnblogs.com/yahuian/p/10813614.html
 * 性质：
 * 1. 非空左子树的所有键值小于其根结点的键值
 * 2. 非空右子树的所有键值大于其根结点的键值
 * 3. 左右子树都是二叉搜索树
 */
package DataStructure.BinaryTree;

public class BinarySearchTree {
    private class Node {
        Node left;
        Node right;
        int data;
    }

    private Node root;

    public void insert(int val) {
        Node curr = new Node();
        curr.data = val;
        if (root==null) {
            root = curr;
        } else {
            Node p = root;
            while (true) {
                // 本程序没有考虑data相同的情况
                // 比当前节点的值大，就添加到右边。如果已经有了右节点，则继续对右节点进行遍历
                if (p.data < curr.data) {
                    if (p.right == null) {
                        p.right = curr;
                        return;
                    } else {
                        p = p.right;
                    }
                }

                else if (p.data > curr.data) {
                    if (p.left == null) {
                        p.left = curr;
                        return;
                    } else {
                        p = p.left;
                    }
                }
            }
        }
    }

     public Node find(int data) {
        Node curr = this.root;
        while (curr != null) {
            if (data > curr.data) {
                curr = curr.right;
            } else if (data == curr.data) {
                return curr;
            } else {
                curr = curr.left;
            }
        }

        return null;
    }

    public void show(Node node) {
        if (node == null) {
            System.out.println("node is null");
        } else {
            System.out.println(node.data);
        }
    }

    // 删除节点分多种情况
    // 1.删除节点有0个孩子，直接删除
    // 2.删除节点有1个孩子
    // 后继节点：如果将一棵二叉树按照中序周游的方式输出，则任一节点的下一个节点就是该节点的后继节点。
    // 为什么是后继节点：因为二叉搜索树按中序遍历输出的话，是排好序的，后继节点即为比删除节点值大的节点中，值最小的那个节点
    public void delete(int data) {
        Node parent = this.root; // 待删除节点的父节点
        Node curr = this.root; // 待删除的节点
        while (curr != null) {
            if (data > curr.data) {
                parent = curr;
                curr = curr.right;
            } else if (data == curr.data) {
                break;
            } else {
                parent = curr;
                curr = curr.left;
            }
        }

        if (curr != null) {

            if (curr.left==null && curr.right==null) { // 删除节点有0个孩子的情况
                if (curr==this.root) this.root = null;
                else {
                    if (curr==parent.left) parent.left = null;
                    else parent.right = null;
                }
            } else if (curr.left!=null && curr.right!=null) { // 删除节点有2个孩子的情况
                Node successorNode = findSuccessor(curr); // 后继节点
                if (curr==parent.left) parent.left = successorNode;
                else parent.right = successorNode;
            } else { // 删除节点有1个孩子的情况
                Node currChild = curr.left == null ? curr.right : curr.left;
                if (curr==parent.left) parent.left = currChild;
                else parent.right = currChild;
            }
        } else {
            System.out.println("delete faild, have not this value");
        }
    }

    /**
     * 寻找要删除节点的后继节点，并将后继节点的右子树移到后继节点的父节点上
     * @param deleteNode
     * @return
     */
    private Node findSuccessor(Node deleteNode) {
        Node curr = deleteNode;
        // 后继节点的父节点
        Node successorParent = deleteNode;
        // 后继节点， 需要将后继节点的右子树挂在后继节点的父节点上
        Node successor = deleteNode.right;

        while (successor.left!=null) {
            successorParent = successor;
            successor = successor.left;
        }

        if (successor!=deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
            successor.left = deleteNode.left;
        }
        return successor;
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();

        for (int value: new int[] {39, 24, 70, 23, 30, 60, 75, 26, 35, 72, 27}) {
            tree.insert(value);
        }
        tree.delete(64);
        tree.preOrder(tree.root);
        Node findNode = tree.find(30);
        tree.show(findNode);
    }
}