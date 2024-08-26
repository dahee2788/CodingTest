package codingtest_ipmoon;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RescuingThePrincess {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i  = 1; i<= n; i++) q.offer(i);
        while (q.size() > 1){
          int x =  q.poll();
          cnt++;
          if(cnt < k) q.offer(x);
          else if(cnt == k) cnt = 0;
        }
//        System.out.println(q.poll());
        System.out.println(solution(n,k));
    }
    static int solution(int n, int k){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i  = 1; i<= n; i++) q.offer(i);
        while (!q.isEmpty()){
            for(int i = 1; i < k; i++) q.offer(q.poll());
            q.poll();
            if(q.size() == 1) answer = q.poll();
        }
        return answer;
    }

}
