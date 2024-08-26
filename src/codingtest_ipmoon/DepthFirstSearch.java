package codingtest_ipmoon;

public class DepthFirstSearch {
    Node root;
    public void DFS(Node root){
        if(root == null) return;
//        System.out.println(root.data); // 전위순회
        DFS(root.lt);
//        System.out.println(root.data); // 중위순회
        DFS(root.rt);
        System.out.println(root.data); // 후위순회

    }
    public static void main(String[] args) {
        DepthFirstSearch tree = new DepthFirstSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);

    }
}
class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        this.data = val;
        this.lt= this.rt = null;
    }
}