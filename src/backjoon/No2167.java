package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][]s = new int[n+1][m+1];
        // 누적합 구하기
        for(int i =1; i < n+1; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            for(int j =1; j < m+1; j++){
               s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
       st = new StringTokenizer(bufferedReader.readLine());
        int k = Integer.parseInt(st.nextToken());
        for(int i =0; i<k; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1]);
        }

    }
}
