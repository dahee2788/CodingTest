package programmers;

public class Factorial_120848 {
    public static void main(String[] args) {
        System.out.println(solution(7));
    }
    public static int solution(int n) {

        int multiplication = 1;
        int answer = 0;
        for(int i = 1; i <= n; i++){
            multiplication *= i;
            if(multiplication == n){
                answer = i;
                break;
            }
            else if(multiplication  > n){
                answer = i -1;
                break;
            }
        }
        return answer;
    }
}
