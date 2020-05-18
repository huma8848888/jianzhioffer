import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {
    static class BinaryNode {
        BinaryNode left;
        BinaryNode right;
        String data;

        public BinaryNode(BinaryNode left, BinaryNode right, String data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        BinaryNode node4 = new BinaryNode(null, null, "4");
        BinaryNode node5 = new BinaryNode(null, null, "5");
        BinaryNode node6 = new BinaryNode(null, null, "6");
        BinaryNode node2 = new BinaryNode(node4, null, "2");
        BinaryNode node3 = new BinaryNode(node5, node6, "3");
        BinaryNode node1 = new BinaryNode(node2, node3, "1");
        Queue<String> resultQueue = new LinkedList<String>();
        resultQueue = serizalize(node1, resultQueue);
        BinaryNode root = deSerialize(new BinaryNode(null, null, ""), resultQueue);
        System.out.printf(root + "");
    }

    //序列化
    private static Queue<String> serizalize(BinaryNode root, Queue<String> queue) {
        if (root == null) {
            queue.add("$");
            return queue;
        }
        queue.add(root.data);
        serizalize(root.left, queue);
        serizalize(root.right, queue);
        return queue;
    }

    //反序列化
    private static BinaryNode deSerialize(BinaryNode root, Queue<String> queue) {
        if (!queue.isEmpty()) {
            root.data = queue.poll();
            root.left = null;
            root.right = null;
            deSerialize(root.left, queue);
            deSerialize(root.right, queue);
        }
        return root;
    }
}
