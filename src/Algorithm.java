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

    static int headerNode = 8;
    static int leftNode = 9;
    static int rightNode = 2;

    public static void main(String[] args) {
        BinaryNode node4 = new BinaryNode(4, null, null);
        BinaryNode node7 = new BinaryNode(7, null, null);
        BinaryNode node2 = new BinaryNode(2, node4, node7);
        BinaryNode node9 = new BinaryNode(9, null, null);
        BinaryNode node8 = new BinaryNode(8, node9, node2);
        BinaryNode node7X = new BinaryNode(7, null, null);
        BinaryNode node8X = new BinaryNode(8, node8, node7X);


    }

    private static boolean findSubTree(BinaryNode head1, BinaryNode head2) {
        boolean result = false;
        if (head1.leftNode == null || head1.rightNode == null) {
            return false;
        }
        if (head1 != null && head2 != null) {
            if (isEqual(head1.data, head2.data)) {

            }
        }
        return false;
    }

    private static boolean isEqual(int num1, int num2) {
        return num1 == num2;
    }

    private static boolean doesTree1HasTree2(BinaryNode node1, BinaryNode node2) {
        return false;
    }


    private static boolean findLeftNode(BinaryNode leftNode) {
        return leftNode.data == leftNode.data;
    }
}
