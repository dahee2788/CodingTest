package codingtest_ipmoon;

import java.util.Scanner;

public class ClimbingStairs {
    static int n;
    static int answer = 0;
    static int[] dy;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        dy = new int[n+1];
        ClimbingStairs t = new ClimbingStairs();
        t.DFS(0);
//        System.out.println(answer);
        System.out.println(t.DY(n));

    }

    void DFS(int sum){
        if(sum > n) return;
        if(sum == n)answer++;
        else{
            DFS(sum + 1);
            DFS(sum + 2);
        }
    }
     int DY(int o){
        if(o == 1) return 1;
        if(o == 2) return 2;
        if(dy[o] != 0 ) return dy[o];
        else return dy[o] = DY(o-2) + DY(o-1);

    }
}
