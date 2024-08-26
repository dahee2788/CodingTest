package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {
    static int n,m,answer  = 0;
    static List<ArrayList<Integer>> list;

    static int [] ch;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        ch = new int[n+1];

        list = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i <= n; i++) list.add(new ArrayList<Integer>()); // 노드 수 만큼 list 항목 추가

        for(int i = 0; i<m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            list.get(a).add(b); // 노드 a에서 이동할 수 있는 노드 b를 a의 항목으로 넣기
        }
        AdjacencyList t = new AdjacencyList();
        ch[1] = 1;
        t.DFS(1);
        System.out.println(answer);
    }
    public void DFS(int v){
        if(v == n) answer++;
        else {
            for(Integer nv : list.get(v)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
}
