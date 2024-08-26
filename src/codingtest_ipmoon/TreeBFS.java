package codingtest_ipmoon;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
    Node root;
    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
//        tree.root.lt.lt = new Node(4);
//        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));


    }
    public int BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        int l = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                Node x = queue.poll();
                if(x.lt == null && x.rt == null) return l;
                else if(x.lt != null) queue.offer(x.lt);
                else if(x.rt != null) queue.offer(x.rt);
            }
            l++;
        }
        return l;
    }
}
