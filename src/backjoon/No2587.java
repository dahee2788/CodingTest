package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class No2587 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[]arr  = new int[5];
        int sum = 0;

        for(int i = 0; i<arr.length; i++) {
            // do something...
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += n;
        }
        bw.write(sum/arr.length + "\n");
        int midIdx = arr.length/2;
        Arrays.sort(arr);
        bw.write(arr[midIdx] + "\n");

        bw.flush();
        bw.close();

    }
}
