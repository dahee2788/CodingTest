package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Scanner;

public class Troublemaker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        StringBuilder answer =  new StringBuilder();
        for(int i = 0; i<n; i++) arr[i] = s.nextInt();
        int [] copyArr = arr.clone(); // 깊은 복사
        Arrays.sort(copyArr);

        for(int j = 0; j < n ; j++){
            if(arr[j] != copyArr[j]) answer.append((j+1) + " ");
        }
        System.out.println(answer);
    }
}
