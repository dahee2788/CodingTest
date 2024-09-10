package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Change_12907 {
    public static void main(String[] args) {
    int n  = 5;
    int [] arr = {1,2,5};
        System.out.println(solution(n,arr));
    }
    public static int solution(int n, int[] money) {
        int [] dp = new int[n+1];
        dp[0] = 1; // 금액 0을 만드는 방법은 1(아무동전도 사용하지 않는다.)
        for(int coin : money) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % 1000000007;
            }
        }
        int answer = dp[n];
        return answer;
    }

}
