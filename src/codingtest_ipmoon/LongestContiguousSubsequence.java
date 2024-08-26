package codingtest_ipmoon;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LongestContiguousSubsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[]arr = new int[n];
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for(int i =0; i<n; i++) arr[i] = s.nextInt();

        int lt = 0, rt = 0, answer = 0;
        while (rt < n){
           if(arr[rt] == 0){
               // 0일때
               if(ad.size() < k){
                   ad.addLast(rt);
               }else {
                   // k기회 다 사용했을때
                   int zeroidx = ad.pollFirst();
                   lt = zeroidx + 1;
                   ad.addLast(rt);
               }
           }
            rt += 1;
            answer = Math.max(rt-lt,answer);
        }
        System.out.println(answer);
        System.out.println(solution(n,k,arr));
    }
    static int solution(int n, int k, int [] arr){
        int answer = 0, cnt = 0, lt = 0;
        for(int rt = 0; rt < n; rt++){
            if(arr[rt] == 0) cnt++;
            while(cnt > k){
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt -lt + 1);
        }
        return answer;
    }
}
