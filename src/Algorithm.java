import java.util.*;

public class Algorithm {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<TreeNode> cabin = new ArrayList<>();
    static Queue<TreeNode> s = new LinkedList<>();
    static Stack<TreeNode> midStack = new Stack<>();

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        preOrder(node1);
        System.out.printf(s + "");
    }

    public static void preOrder(TreeNode Root) {
        if (Root == null) {
            System.out.println("空树");
            return;
        }
        TreeNode tmp = Root;
        s.add(tmp);  //根节点入栈
        while (!s.isEmpty()) {
            //1.访问根节点
            TreeNode p = s.poll();
            System.out.print(p.val + " ");
            //3.如果根节点存在左孩子，则将左孩子入栈
            if (p.left != null) {
                s.add(p.left);
            }
            //2.如果根节点存在右孩子，则将右孩子入栈
            if (p.right != null) {
                s.add(p.right);
            }
        }
        System.out.println();
    }

    public static void midOrder(TreeNode node) {
        if (node == null) {
            System.out.printf("空");
            return;
        }
        TreeNode root = node;
        TreeNode temp = node;
        while (root.right != null) {
            temp = temp.right;
        }
        midStack.add(root);
    }

    public static void aftOrder(TreeNode node) {


    }

//    public static void loop(TreeNode root){
//        if (root == null){
//           cabin.add(root);
//           return;
//        }
//        while (root.left != null){
//            loop(root.left);
//            cabin.add(root);
//            break;
//        }
//        cabin.add(root);
//        while (root.right != null) {
//            loop(root.right);
//            cabin.add(root);
//            break;
//        }
//    }
}
