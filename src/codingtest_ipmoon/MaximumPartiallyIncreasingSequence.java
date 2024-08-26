package codingtest_ipmoon;

import java.util.Scanner;

public class MaximumPartiallyIncreasingSequence {
    static int n;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = s.nextInt();
        }
        MaximumPartiallyIncreasingSequence t = new MaximumPartiallyIncreasingSequence();
        System.out.println(t.DY(arr));
    }
    int DY(int [] arr){
        int answer = 0;
        int [] dy = new int[arr.length];
        dy[0] = 1; // 첫 항목은 나밖에 없으니까 무조건 1 /* 초기 값들을 잘 생각해보자 */
        for(int i = 0; i< arr.length; i++){
            int max = 0; // max는 0으로 초기화 => 4 6 7 2 2의 경우 앞에 작은 수가 하나도 없어서 값이 0이 됨 /* 하나의 항목에 여러 경우 중에서 max */
            for(int j = i-1; j >=0; j--){
                if(arr[j] < arr[i] && max < dy[j]) max = dy[j];
            }
            dy[i] = max+1;
            answer = Math.max(answer,dy[i]);
        }
        return answer;
    }
}
