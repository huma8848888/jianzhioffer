public class Algorithm {
    public static class Node {
        Node next;
        int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }

    public Algorithm() {
    }

    //翻转链表
    public static void main(String[] args) {
        Node node9 = new Node(null, 9);
        Node node7 = new Node(null, 7);
        Node node5 = new Node(null, 5);
        Node node3 = new Node(null, 3);
        Node node1 = new Node(null, 1);

        Node node10 = new Node(null, 10);
        Node node8 = new Node(null, 8);
        Node node6 = new Node(null, 6);
        Node node4 = new Node(null, 4);
        Node node2 = new Node(null, 2);


        connectNodes(node1, node3);
        connectNodes(node3, node5);
        connectNodes(node5, node7);
        connectNodes(node7, node9);
        connectNodes(node9, null);

        connectNodes(node2, node4);
        connectNodes(node4, node6);
        connectNodes(node6, node8);
        connectNodes(node8, node10);
        connectNodes(node10, null);

        Node head = conJunction(node1, node2);
        while (head.next != null) {
            System.out.printf(head.data + "");
            head = head.next;
        }
    }

    private static Node conJunction(Node head1, Node head2) {
        Node head1Pointer = head1;
        Node head2Pointer = head2;
        if (head1Pointer == null) {
            return head2Pointer;
        } else {
            if (head2Pointer == null) {
                return head1Pointer;
            }
            //如果没有匹配到这里面的规则，那么就进行正常的连接操作
        }
        Node newHead = null;
        if (head1Pointer.data < head2Pointer.data) {
            newHead = head1Pointer;
            newHead.next = conJunction(head1.next, head2);
        } else {
            newHead = head2;
            newHead.next = conJunction(head1, head2.next);
        }
        return newHead;
    }


    //将现有链表头输入，输出新的链表头
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        Node newNode = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newNode;
    }

    public static void connectNodes(Node pre, Node next) {
        pre.next = next;
    }
}
