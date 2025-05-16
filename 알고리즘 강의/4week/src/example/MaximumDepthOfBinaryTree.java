package example;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = dfs(root, 0);
        System.out.println(depth);
    }
    static int dfs (TreeNode root, int count){
        if (root==null){
            return count;
        }
        int distLeft = dfs(root.left, count+1);
        int distRight = dfs(root.right, count+1);

        return Math.max(distLeft, distRight);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

}