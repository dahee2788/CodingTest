package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInAGraphLevel {
    static int n,m;
    static int [] ch,level;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();

        ch = new int[n+1];
        level = new int[n+1];

        for(int i = 0; i<=n; i++) graph.add(new ArrayList<Integer>());
        for(int i = 0; i< m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            graph.get(a).add(b);
        }
        ShortestPathInAGraphLevel t = new ShortestPathInAGraphLevel();
        t.BFS(1);
        for(int i = 2; i<= n; i++){
            System.out.println(i + " : " +level[i]);
        }
    }

    public void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        level[v] = 0; // 본인 자신은 자신과의 거리 0;
        int l = 0;

        queue.offer(v);
        while (!queue.isEmpty()){
            int len = queue.size(); // 레벨로 구할때 현재의 length 만큼 for문 돌리기
            for(int i =0; i<len; i++){
                int cv = queue.poll();
                level[cv] = l;
                for(int nv : graph.get(cv)){
                    if(ch[nv] == 0){
                        ch[nv] = 1;
                        queue.offer(nv);
                    }
                }
            }
            l++;
        }
    }
}
