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


    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
    }
}
