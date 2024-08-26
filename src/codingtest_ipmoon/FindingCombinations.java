package codingtest_ipmoon;

import java.util.Scanner;

public class FindingCombinations {
    static int n,m;
    static int arr[];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        arr = new int[m];
        FindingCombinations t = new FindingCombinations();
        t.DFS(0,1);

    }
    public void DFS(int l, int s){
        if(l == m){
            for (int a: arr) System.out.print(a + " ");
            System.out.println();
        }else {
            for(int i = s; i <=n; i++){
                arr[l] = i;
                DFS(l+1, i+1); // 중복 순열 방지
            }
        }
    }
}
