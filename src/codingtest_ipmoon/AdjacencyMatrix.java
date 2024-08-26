package codingtest_ipmoon;

import java.util.Scanner;

public class AdjacencyMatrix{
    static int n,m,answer = 0;
    static int [][] graph;
    static int [] ch;
    public static void main(String[] args) {
        AdjacencyMatrix t = new AdjacencyMatrix();
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for (int i = 0; i<m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        t.DFS(1);
        System.out.println(answer);
    }
    public void DFS(int v){
        if(v == n) answer++;
        else{
            for(int i =1; i<=n; i++){
                if(graph[v][i] == 1 && ch[i] == 0){
                    // 방향 ok, 방문한적없으면 진행
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }

    }
}
