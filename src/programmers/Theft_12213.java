package programmers;

public class Theft_12213 {
    public static void main(String[] args) {
//    int [] arr = {1, 2, 3, 1};
//    int [] arr = {91, 90, 5, 7, 5, 7};
    int [] arr = {90, 0, 0, 95, 1, 1};
        System.out.println(solution(arr));
    }
    public static int solution(int[] money) {
        int n = money.length;

        // 첫 번째 집을 털고 마지막 집을 털지 않는 경우
        int[] dp1  = new int[n]; // 해당 집까지 털었을때 가장 많은 금액
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]); // 첫번째 집만 털거나, 첫번째 집을 털지 않고 두번째 집만 털었을때의 가장 큰 금액

        for (int i = 2; i < n -1 ; i++) { // 마지막 집은 털지 않기 때문에 제외
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]); // 털지 않고 직전 금액 계승, 지지난 금액 + 현재 금액 더하면서 턴다.
        }
        dp1[n-1] = dp1[n-2]; // 마지막 집은 털지 않고, 지지난 집의 최대금액 계승

        // 첫번째 집을 털지 않고 두번째 집을 터는 경우
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]); // 두번째 집만 털거나, 두번째 집을 털지 않고 세번째 집만 털었을때의 가장 큰 금액

        for (int i = 3; i < n ; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        return Math.max(dp1[n-1], dp2[n-1]);
    }

}
