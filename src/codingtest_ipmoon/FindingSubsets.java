package codingtest_ipmoon;

import java.util.Scanner;

public class FindingSubsets {
    static int n;
    static int[] ch; // 부분집합을 구하는 건 숫자가 포함되고 안되고의 모음 (1 : o or x ... )
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        ch = new int[n+1];
        DFS(1);
    }

    static void DFS(int number){
        if(number == n+1){
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i<=n; i++){
                if(ch[i] == 1) sb.append(i + " ");
            }
            System.out.println(sb.toString());
        }else {
            ch[number] = 1; // 현재 숫자 포함
            DFS(number+1); // 다음 숫자 노드 이동
            ch[number] = 0; // 현재 숫자 불포함
            DFS(number+1); // 다음 숫자 노드 이동
        }
    }
}
