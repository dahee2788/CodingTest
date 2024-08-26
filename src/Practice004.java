import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.valueOf(stringTokenizer.nextToken());
        int m = Integer.valueOf(stringTokenizer.nextToken());

        int [][] a = new int[n+1][n+1];
        for(int i = 1; i<n+1; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 1; j < n+1; j++){
                a[i][j] = Integer.valueOf(stringTokenizer.nextToken());
            }
        }

        int [][] s = new int[n+1][n+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + a[i][j];
            }
        }
        for(int i = 0; i<m; i++){
            stringTokenizer =  new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.valueOf(stringTokenizer.nextToken());
            int y1 = Integer.valueOf(stringTokenizer.nextToken());
            int x2 = Integer.valueOf(stringTokenizer.nextToken());
            int y2 = Integer.valueOf(stringTokenizer.nextToken());

            System.out.println(s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1]);
        }

    }
}
