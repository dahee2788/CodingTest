package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

public class ChoosingAnInterimLeader {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] arr = new int[n][5];
        int [][] students = new int[n][n];
        int [] studentsCnt = new int[n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j < 5; j++){
                arr[i][j] = s.nextInt();
            }
        }

        for(int i = 0; i<5; i++){
            for(int j = 0; j <n; j++){
                int css = arr[j][i];
                for(int c = 0; c < n; c++){
                        if(j != c && css == arr[c][i]){
                            students[j][c] = 1;
                        }
                }
            }
        }

        int idx = 0;
        for(int f = 0; f<n; f++){
            int sum1= 0;
            int sum2 = 0;
            for(int fj = 0; fj<n; fj++){
                sum1 += students[idx][fj];
                sum2 += students[f][fj];
            }
            if(sum1 < sum2) idx = f;

        }
//        System.out.println(idx+1);
        System.out.println(solution(n,arr) + 1);
    }
    static int solution(int n, int [][]arr){
    int answer = 0,max=0;
    for(int i = 0; i<n; i++){
        int cnt = 0;
        for(int j = 0; j<n; j++){
           for(int k=0; k<5; k++){
               if(arr[i][k] == arr[j][k]){
                   cnt++;
                   break; // 같은 학년에서 같은 반 1회 체크되었기 때문에 break; 해당학년에서는 더 체크할 필요 없음
               }
           }
        }
        if(cnt > max){
            max = cnt;
            answer = i;
        }
    }
    return answer;
    }
}
