import java.util.Stack;

public class Algorithm {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
//        preOrder(node1);
//        midOrder(node1);
        postOrder(node1);
    }

    static void preOrder(Node head) {
        //将头结点压栈，然后弹出栈顶，并将栈顶的右节点和左节点压栈
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        Node node = head;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            System.out.print(node.val);
        }
    }

    static void midOrder(Node head) {
        //一直遍历到左子节点为空，然后弹出栈顶，将栈顶的右节点压栈，知道右节点的左子节点为空
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.print(pop.val);
                node = pop.right;
            }
        }
    }

    static void postOrder(Node head) {
        //先压栈，然后将栈顶弹出，放入out中，然后将弹出节点的左右节点分别放入in中
        Stack<Node> in = new Stack<>();
        Stack<Node> out = new Stack<>();
        in.push(head);
        while (!in.isEmpty()) {
            Node node = in.pop();
            out.push(node);
            if (node.left != null)
                in.push(node.left);
            if (node.right != null)
                in.push(node.right);
        }

        while (!out.isEmpty()) {
            System.out.print(out.pop().val);
        }

    }
}
