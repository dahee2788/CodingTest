package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.PriorityQueue;

public class Overtimeindex_12927 {
    public static void main(String[] args) {
        int n = 4;
//        int n = 1;
//        int n = 3;
        int [] works = {4, 3, 3};
//        int [] works = {2, 1, 2};
//        int [] works = {1,1};
        System.out.println(solution(n, works));

    }
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            queue.offer(work);
        }
        while (n > 0){
           int current =  queue.poll();
            queue.offer(current > 0?current-1:current );
            n--;
        }
       long answer = 0;
        for(int q : queue){
            if(q > 0) answer += (long) Math.pow(q, 2);
        }
        return answer;
    }
}
