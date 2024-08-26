import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        long[]a = new long[n];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for(int i =0; i<a.length; i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);
        int cnt = 0;
        for(int i = 0; i < a.length; i++){
            int s = 0;
            int e = n-1;
//            int e = i; // 예시로 인해 생각이 좁혀짐. 끝포인터를 해당 수로 지정할 필요 없음
            long m = a[i];
            while (s < e){
                long sum = a[s] + a[e];
                if(sum < m) s++;
                else if(sum > m) e--;
                else {
                    if(s != i && e != i){
                        cnt++;
                        break;
                    }
                    else if( s == i) s++;
                    else if( e == i) e--;
                }
            }
        }
        System.out.println(cnt);
    }
}
