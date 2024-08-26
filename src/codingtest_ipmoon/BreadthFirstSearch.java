package codingtest_ipmoon;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    Node root;
    public void BFS(Node root){
        // 넓이우선찾기 BFS는 queue를 이용 : 레벨 별로 item 호출
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int l = 0; // 레벨은 0으로 초기화
        while (!queue.isEmpty()){
            int len = queue.size(); // queue 사이즈 만큼 for문
            for(int i =0; i<len; i++){
                // 꺼내기
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) queue.offer(cur.lt);
                if(cur.rt != null) queue.offer(cur.rt);
            }
            l++; // for문 끝나면 레벨 업
        }

    }
    public static void main(String[] args) {
        BreadthFirstSearch tree = new BreadthFirstSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);

    }

}
