package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Scanner;

public class CoinExchange_KnapsackAlgorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for(int i= 0; i<n; i++) arr[i] = s.nextInt();
        int m = s.nextInt();
        int [] dy = new int[m+1]; // dy[i]에는 i 금액을 만드는데 사용 되는 동전의 최소 개수
        Arrays.fill(dy,Integer.MAX_VALUE); //  배열을 채우기
//        for(int i = 1; i<=m; i++) dy[i] = Integer.MAX_VALUE;
        Arrays.sort(arr);
        dy[0] = 0; // 초기값 설정
        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j <= m; j++){ // 동전의 가격 부터 시작
                if(dy[j] > (dy[j - arr[i]] + 1)) dy[j] = (dy[j - arr[i]] + 1); // 현재위치(이전 단위의 동전으로 계산) - 동전 단위
                 // => 이전 단계의 계산에서 현재 단위의 동전을 한개 씀으로 인해 현재의 위치의 동전 개수 보다 더 적어질 수 있음 ( 그래서 이전 위치 + 1)
            }
        }
        System.out.println(dy[m]);
    }
}
