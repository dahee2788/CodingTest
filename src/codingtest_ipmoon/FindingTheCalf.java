package codingtest_ipmoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindingTheCalf {
    static int [] dis = {1,-1,5};
    static int [] ch = new int[10001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.println(BFS(s,e));

    }
    static int BFS(int s, int e){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s); // 시작 지점 넣고 start
        ch[s] = 1; // root 1로 넣고 시작
        int l = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                int x = queue.poll();
                if(x == e) return l;
                // 자식 노드 만들기
                for(int d = 0; d<dis.length; d++){
                    int n = x+dis[d];
                    if(n > -1 && n <= ch.length && ch[n] == 0){ // 방문 아직 안했을때
                        ch[n] = 1;
                        queue.offer(n);
                    }
                }
            }
            l++;
        }
        return l;
    }
}
