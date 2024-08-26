import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice006 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = 1;
        int s = 1;
        int e = 1;
        int sum = 1;
        while (e != n){
            if(sum == n){
                c++;
                e++;
                sum = sum + e;
            }
            else if(sum < n){
                e++;
                sum = sum + e;
            }
            else{
                sum = sum - s;
                s++;
            }
        }
                System.out.println(c);
    }
}
