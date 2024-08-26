import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []a = new int [n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a.length-1; j++){
                if(a[j]>a[j+1]){
                    int tmp =a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        for (int ab:a) {
            System.out.println(ab);
        }
    }
}
