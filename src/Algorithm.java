import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {
    static class BinaryNode {
        int data;
        BinaryNode leftNode;
        BinaryNode rightNode;

        public BinaryNode(int data, BinaryNode leftNode, BinaryNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    public static void main(String[] args) {
        BinaryNode node5 = new BinaryNode(5, null, null);
        BinaryNode node7 = new BinaryNode(7, null, null);
        BinaryNode node9 = new BinaryNode(9, null, null);
        BinaryNode node11 = new BinaryNode(11, null, null);
        BinaryNode node6 = new BinaryNode(6, node5, node7);
        BinaryNode node10 = new BinaryNode(10, node9, node11);
        BinaryNode node8 = new BinaryNode(8, node6, node10);
//        printBinaryTreeHorizontal(node8);
//        printBinaryTreeWithQueue(node8);
        printBinaryTreeWithQueueZigZag(node8);
    }

    private static boolean isHeaderPrinted = false;

    //递归实现
    private static void printBinaryTreeHorizontal(BinaryNode head) {
        BinaryNode subTreeHead = head;
        if (!isHeaderPrinted) {
            System.out.printf(subTreeHead.data + "");
            isHeaderPrinted = true;
        }
        if (head.leftNode == null && head.rightNode == null) {
            return;
        }
        System.out.printf(subTreeHead.leftNode.data + "");
        System.out.printf(subTreeHead.rightNode.data + "");

        if (subTreeHead.leftNode != null) {
            printBinaryTreeHorizontal(subTreeHead.leftNode);
        }

        if (subTreeHead.rightNode != null) {
            printBinaryTreeHorizontal(subTreeHead.rightNode);
        }
    }

    //采用队列实现二叉树的广度优先遍历
    private static final Queue<BinaryNode> queue = new LinkedList<>();
    private static void printBinaryTreeWithQueue(BinaryNode head) {
        BinaryNode node = head;
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryNode header = queue.poll();
            System.out.printf(header.data + "");
            if (header.leftNode != null) {
                queue.add(header.leftNode);
            }
            if (header.rightNode != null) {
                queue.add(header.rightNode);
            }
        }
    }

    //之字形打印二叉树，使用队列的解法
    private static void printBinaryTreeWithQueueZigZag(BinaryNode head) {
        if (head == null) {
            return;
        }
        BinaryNode node = head;
        queue.add(node);
        boolean isForward = false;//是否从左往右打印
        while (!queue.isEmpty()) {
            BinaryNode header = queue.poll();
            System.out.printf(header.data + "");
            if (isForward) {
                if (header.leftNode != null) {
                    queue.add(header.leftNode);
                }
                if (header.rightNode != null) {
                    queue.add(header.rightNode);
                }
                isForward = false;
            } else {
                if (header.rightNode != null) {
                    queue.add(header.rightNode);
                }
                if (header.leftNode != null) {
                    queue.add(header.leftNode);
                }
                isForward = true;
            }
        }


    }
}
