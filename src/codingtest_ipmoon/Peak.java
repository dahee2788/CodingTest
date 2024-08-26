package codingtest_ipmoon;

import java.util.Scanner;

public class Peak {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        int[][]arr = new int[n][n];
        int cnt = 0;
        for (int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = s.nextInt();
            }
        }
        // 봉우리 개수 세기
        for (int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int crt = arr[i][j];
                //상
                int t = j == 0? 0: arr[i][j-1];
                //우
                int r = i == n-1? 0:arr[i+1][j];
                //하
                int b = j == n-1? 0:arr[i][j+1];
                //좌
                int l = i == 0? 0:arr[i-1][j];


                if(Math.max(Math.max(Math.max(t,b),l),r) < crt) cnt++;
            }
        }
//        System.out.println(cnt);
        System.out.println(solution(n,arr));

    }
    static int solution(int n, int [][] arr){
        int answer = 0;
        int [] dx = {0, 1, 0 , -1};
        int [] dy = {-1, 0, 1 , 0};
        for (int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
               boolean biggest = true;
               for(int a = 0; a<4;  a++){
                   int nx = i+dx[a];
                   int ny = j+dy[a];
                   if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] >= arr[i][j]){
                           biggest = false;
                           break;
                   }
               }
               if(biggest) answer++;
            }
        }
        return answer;
    }
}
