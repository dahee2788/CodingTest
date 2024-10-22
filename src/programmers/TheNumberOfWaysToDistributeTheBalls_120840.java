package programmers;

public class TheNumberOfWaysToDistributeTheBalls_120840 {
    public static void main(String[] args) {
        System.out.println(solution(30,10));

    }

    public static int solution(int balls, int share) {

        int answer = 0;
        answer = combination(balls, share);
        return answer;

    }

    public static int combination(int n, int r) {
        if (n == r | r == 0) return 1;
        else return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
