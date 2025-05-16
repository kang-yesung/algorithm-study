package example;

public class LowestCommonAncestorOfABinaryRee {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(5);
        root.right = new Tree(1);
        root.left.left = new Tree(6);
        root.left.right = new Tree(2);
        root.right.left = new Tree(0);
        root.right.right = new Tree(8);
        root.left.right.left = new Tree(7);
        root.left.right.right = new Tree(4);

        Tree p = root.left;    // 값이 5
        Tree q = root.right;   // 값이 1

        Tree depth = dfs(root, p, q);
        System.out.println(depth.val);

    }
    public static Tree dfs(Tree root, Tree p, Tree q){
        if (root == null || root == p || root == q) {
            return root;
        }

        Tree left = dfs(root.left, p, q);
        Tree right = dfs(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}


class Tree{
    int val;
    Tree left;
    Tree right;

    public Tree(int val) {
        this.val = val;
    }

}

