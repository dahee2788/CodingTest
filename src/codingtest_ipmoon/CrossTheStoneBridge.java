package codingtest_ipmoon;

import java.util.Scanner;

public class CrossTheStoneBridge {
    static int n;
    static int[] dy;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n  = s.nextInt();
        n = n+1;
        dy = new int[n+1];
        CrossTheStoneBridge t  = new CrossTheStoneBridge();
        System.out.println(t.DY(n));
    }
    int DY(int o){
        if(o == 1) return 1;
        if(o == 2) return 2;
        if(dy[o] != 0) return dy[o];
        else return dy[o] = DY(o-2) + DY(o -1);
    }
}
