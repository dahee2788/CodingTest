package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class GettingTheMaximumScore {
    static int n,m,answer = 0;
    static ArrayList<Problem> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        for(int i = 0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            Problem p = new Problem(a,b);
            list.add(p);
        }
        GettingTheMaximumScore t = new GettingTheMaximumScore();
        t.DFS(0,0,0);
        System.out.println(answer);
    }

    public void DFS(int v, int score, int time){
        if(v == n){
            if(time <= m){
                answer = Math.max(answer, score);
            }
        }else{
            Problem p = list.get(v);
            DFS(v+1,score+p.score, time+p.time);
            DFS(v+1,score, time);
        }
    }
}
class Problem{
    int score;
    int time;
    public Problem(int score, int time){
        this.score = score;
        this.time = time;
    }
}
