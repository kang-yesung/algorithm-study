package example;

public class TreeDFS이진트리 {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(8);
        root.left.left = new Node(10);
        root.left.right = new Node(7);
        root.right = new Node(5);

        System.out.println(dfsCount(root));

    }

    static int dfsCount(Node root){
        if(root==null) return 0;

        int ret1 = dfsCount(root.left);
        int ret2 = dfsCount(root.right);

        // return ret1 +  ret2 + 1; //노드 수 확인
        return ret1 + ret2 + root.value; // 노드번호의 합
    }


    //전위 순회: 루트 → 왼쪽 → 오른쪽
    static void dfs1(Node root) {
        System.out.println("방문노드" + root.value);
        if (root.left != null) dfs1(root.left);
        if (root.right != null) dfs2(root.right);
        /*
         * 방문노드1
         * 방문노드8
         * 방문노드10
         * 방문노드7
         * 방문노드5
         * */

    }

    // 중위 순회: 왼쪽 → 루트 → 오른쪽
    static void dfs2(Node root) {
        if (root.left != null) dfs2(root.left);
        System.out.println("방문노드" + root.value);
        if (root.right != null) dfs2(root.right);
        /*
         * 방문노드10
         * 방문노드8
         * 방문노드7
         * 방문노드1
         * 방문노드5
         * */

    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    static void dfs3(Node root) {
        if (root.left != null) dfs3(root.left);
        if (root.right != null) dfs3(root.right);
        System.out.println("방문노드" + root.value);
        /*
         * 방문노드10
         * 방문노드7
         * 방문노드8
         * 방문노드5
         * 방문노드1
         * */

    }
}
class  Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
