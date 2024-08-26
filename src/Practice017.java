import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        int a[] = new int[numbers.length()];
        for(int i = 0; i<a.length; i++){
            a[i] = Integer.parseInt(numbers.substring(i,i+1));
        }

        for(int i =0; i < a.length; i++){
            int max = i;
            for(int j = i+1; j < a.length; j++){
                if(a[max] <  a[j]){
                    max = j;
                }
            }
            int temp = a[i];
            a[i] = a[max];
            a[max] = temp;
        }
        for (int i = 0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }
}
