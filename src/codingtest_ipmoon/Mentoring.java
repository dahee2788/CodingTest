package codingtest_ipmoon;

import java.util.Scanner;

public class Mentoring {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int [][]arr =  new int[m][n];
        int [][]mCheckArr =  new int[n+1][n+1];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = s.nextInt();
            }
        }

        for(int i = 0; i<n; i++){
            int studentNum = i + 1;
            int [] mArr = new int[n+1];
            for(int j = 0; j<m; j++){
                int sc = -1;
                for(int k = 0; k<n; k++){

                    if(studentNum == arr[j][k]){
                     sc = k;
                    }
                    if(sc > -1 && sc < k){
                        mArr[arr[j][k]] += 1;
                    }
                }
            }
            for(int a =1; a<n+1; a++){
                if(mArr[a] == m) mCheckArr[studentNum][a] = 1;
            }
        }
        int cnt = 0;
        for(int b = 0; b <= n; b++ ){
            for(int d = 0; d <=n; d++){
                if(mCheckArr[b][d] == 1) cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(solution(n,m,arr));
    }
    static int solution(int n, int m, int [][] arr){
        int answer = 0;
        for(int i = 1; i<= n; i++){ // 멘토
            for(int j = 1; j<=n; j++){ // 멘티
                int cnt = 0;
                for(int k = 0; k<m; k++){ // 시험
                    int pi = 0;
                    int pj = 0;
                    for(int s =0; s<n; s++){ // 등수
                        if(i == arr[k][s]) pi = s;
                        if(j == arr[k][s]) pj = s;
                    }
                    if(pi < pj) cnt++; // j가 더 등수가 낮으면
                }
                if(cnt == m) answer++;
            }

        }
        return answer;
    }
}
