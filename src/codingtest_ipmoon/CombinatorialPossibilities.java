package codingtest_ipmoon;

import java.util.Scanner;
public class CombinatorialPossibilities {
    static int[][] arr ;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       int  n = s.nextInt();
       int  r = s.nextInt();
       arr = new int[n+1][r+1];
        CombinatorialPossibilities t = new CombinatorialPossibilities();
        System.out.println(t.DFS(n,r));
    }
    public int DFS(int n, int r){
        if(arr[n][r] != 0) return arr[n][r];
        if(n == r || r == 0) return arr[n][r] = 1;
        else return arr[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }
}
