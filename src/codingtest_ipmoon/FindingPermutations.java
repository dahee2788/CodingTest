package codingtest_ipmoon;

import java.util.Scanner;

public class FindingPermutations {
    static int n,m;
    static int [] pm, arr, chk;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        pm = new int[m];
        arr = new int[n];
        chk = new int[n];
        for(int i = 0; i<n; i++) arr[i] = s.nextInt();

        FindingPermutations t = new FindingPermutations();
        t.DFS(0);

    }
    public void DFS(int l){
        if(l == m) {
            for (int a:pm) System.out.print(a+" ");
            System.out.println();
        }
        else {
            for(int i =0; i<n; i++){
                if(chk[i] == 0){
                    pm[l] = arr[i];
                    chk[i] = 1;
                    DFS(l + 1);
                    chk[i] = 0;
                }
            }
        }
    }
}
