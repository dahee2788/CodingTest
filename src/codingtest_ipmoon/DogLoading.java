package codingtest_ipmoon;

import java.util.Scanner;

public class DogLoading {
    static int c,n,answer = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        c = s.nextInt();
        n = s.nextInt();
        int [] w = new int[n];
        for(int i=0; i<n;i++) w[i] = s.nextInt();
        DogLoading t = new DogLoading();
        t.DFS(0,0,w);
        System.out.println(answer);
    }
    public void DFS(int v, int sum, int [] w){
        if(sum > c) return;
        if(v == n) answer = Math.max(answer,sum);
        else {
            DFS(v + 1, sum + w[v], w);
            DFS(v + 1, sum, w);
        }
    }
}
