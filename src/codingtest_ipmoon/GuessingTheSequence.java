package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessingTheSequence {
    static int n,f;
    static int [] ch;
    static int [][] triArr,comArr;
    static int [] pm,bm;

    static boolean flag;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        f = s.nextInt();
        ch = new int[n];
        triArr = new int[n][n];
        comArr = new int[n+1][n+1];
        pm = new int[n];
        bm = new int[n];

        GuessingTheSequence t = new GuessingTheSequence();
        for(int i =0; i<n; i++) bm[i] =t.Combination(n-1,i);

        t.DFS(0,0);
//        for(int a : list.get(0)) System.out.print (a + " ");
    }

    /* 내 풀이.. */
    public void DFS(int l){
        if(l == n){
            for(int i =1; i<n; i++){
                for(int j = 0; j < n; j++){
                    triArr[i][j] = 0;
                }
            }
            if(f == triangle(n-1,0)) {
                ArrayList<Integer> alist = new ArrayList<>();
                for(int i = 0; i< n; i++) alist.add(triArr[0][i]);
                list.add(alist);
            }
        }else {
            for(int i = 0; i <n; i++){
                if(ch[i] == 0){
                    triArr[0][l] = i+1;
                    ch[i] = 1;
                    DFS(l+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public int triangle(int l, int v){
        if(triArr[l][v] != 0) return triArr[l][v];
        else return triArr[l][v] = triangle(l-1,v) + triangle(l-1,v+1);
    }

    /* 선생님 풀이 */
    public void DFS(int l, int sum){
        if(flag) return;
        if(l == n && sum == f){
            for(int i = 0; i< n; i++) System.out.print(pm[i] + " ");
            flag  = true;
        }else {
            for(int i = 0; i <n; i++){
                if(ch[i] == 0){
                    pm[l] = i+1;
                    ch[i] = 1;
                    DFS(l+1,sum + (pm[l] * bm[l]));
                    ch[i] = 0;
                }
            }
        }
    }
    public int Combination(int n, int r){
        if(comArr[n][r] != 0) return comArr[n][r];
        if(n == r || r == 0) return comArr[n][r] = 1;
        else return Combination(n-1,r-1) + Combination(n-1,r);
    }
}
