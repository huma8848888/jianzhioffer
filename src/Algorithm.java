public class Algorithm {
    //翻转链表
    public static void main(String[] args) {
        Node node5 = new Node(null, 5);
        Node node4 = new Node(null, 4);
        Node node3 = new Node(null, 3);
        Node node2 = new Node(null, 2);
        Node node1 = new Node(null, 1);
        connectNodes(node1, node2);
        connectNodes(node2, node3);
        connectNodes(node3, node4);
        connectNodes(node4, node5);
        connectNodes(node5, node3);
        System.out.printf(isCircle(node1) + "");
    }

    public static void connectNodes(Node pre, Node next) {
        pre.next = next;
    }

    //判断循环链表中是否有环
    public static boolean isCircle(Node header) {
        if (header.next == null) {
            //单节点没有环
            return false;
        }
        //每次走一步
        Node nodeSlow = nextNode(header);
        //每次走两步
        Node nodeFast = nextNode(nextNode(header));
        if (nodeFast == null) {
            return false;
        } else {
            boolean isFound = false;
            while (!isFound) {
                nodeSlow = nextNode(nodeSlow);
                nodeFast = nextNode(nextNode(nodeFast));
                if (nodeFast == null) {
                    return false;
                }
                if (nodeFast == nodeSlow) {
                    isFound = true;
                }
            }
            return isFound;
        }


    }

    //返回下一个节点的值
    public static Node nextNode(Node node) {
        return node.next;
    }

    public static class Node {
        Node next;
        int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }
}
