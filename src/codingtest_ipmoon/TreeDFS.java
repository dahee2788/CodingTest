package codingtest_ipmoon;

public class TreeDFS {
    Node root;
    public int DFS(int l, Node root){
        if(root.lt == null && root.rt == null) return l;
        else {
            ++l;
            return Math.min(DFS(l, root.lt), DFS(l,root.rt));
        }
    }
    public static void main(String[] args) {
        TreeDFS tree = new TreeDFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0,tree.root));
    }
}
