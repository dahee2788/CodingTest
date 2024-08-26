import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄 쓸때마다
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[]s = new long[suNo + 1]; // +1 하는 이유는 자연수 대상이기때문에 계산하기 편하라고
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i= 1; i<s.length; i++){
            s[i] = s[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int q = 0; q<quizNo; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] - s[i-1]);
        }
    }
}
