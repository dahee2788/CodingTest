import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 아무거나
        for(int i = 1; i<a.length; i++){
            int j = i-1;
            int num = a[i];
            while (j >= 0 && num<a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = num;
        }
        // 합배열 만들기

        int sum = 0;
        int []s = new int[n];
        for(int i = 0; i<n; i++){
            if(i == 0) s[i] = a[i];
           else s[i] = s[i-1] + a[i];
        }
        for (int arr:
             s) {
            sum += arr;
        }
        System.out.println(sum);

    }
}
