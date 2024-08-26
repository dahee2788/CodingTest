import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice005 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.valueOf(stringTokenizer.nextToken());
        int m = Integer.valueOf(stringTokenizer.nextToken());

        long[]a = new long[n+1];
        long[]s = new long[n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i =1; i<a.length; i++){
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i<s.length; i++){
            s[i] = s[i-1] + a[i];
        }

        long []c = new long[m];
        long answer = 0;
        for(int i = 1; i<n+1; i++){
            int r = (int)(s[i]%m); // s[i]%m 를 괄호로 감싸지 않으면 outbound 에러
            if(r == 0) answer++;
            c[r]++; // 나머지와 인덱스가 같은 원소에 카운트, 예를 들면 나머지가 0이다, c[0]에 +1
        }
        for(int i = 0; i<m; i++){
            if(c[i] > 1){ // 나머지의 값이 같은 두 구간의 합을 찾는 것이기 때문에 2개이상인 요소에서 경우의 수 검색
                answer = answer + (c[i] * (c[i] -1) / 2);
            }
        }

        System.out.println(answer);
    }
}

