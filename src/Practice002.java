import java.util.Scanner;

public class Practice002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 첫번째 숫자 입력받기
        int N = sc.nextInt();
        // 입력받은 숫자만큼의 길이를 가진 int 배열 만들기
        int [] A = new int[N];

        for(int i = 0; i<N; i++){
            // N만큼 숫자입력 받고 배열에 넣기
            A[i] = sc.nextInt();
        }
        // 합, 최대값 초기화
        long sum = 0;
        long max = 0;
        for(int i= 0; i<N; i++){
            if(max < A[i]) max = A[i];
            sum += A[i];
        }
        // 총합 * 100 / max / n : 소수점 계산을 위해 100.0을 곱함
        double answer = sum * 100.0 / max / N;
        System.out.println(answer);
    }
}
