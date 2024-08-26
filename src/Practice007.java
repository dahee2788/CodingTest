import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 한 줄에 한 개씩만 받는 거면 bufferedReader 바로 사용

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        int []a = new int[n];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for(int i =0; i<a.length; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(a);

        int i = 0; // 시작 포인터
        int j = n-1; // 끝 포인터
        int cnt = 0;

        while (i < j){ // i 가 j 보다 작을때까지
            int sum = a[i] + a[j];
            if(sum < m){
                i++;
            }
            else if(sum > m){
                j--;
            }
            else {
                i++;
                j--;
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}
