package codingtest_ipmoon;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for(int a = 0; a<n; a++) arr[a] = s.nextInt();

        for(int i = 0; i<n-1; i++){
            int idx = i;
            for(int j = i+1; j<n; j++){
                if(arr[j] < arr[idx])idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        for (int x = 0; x < arr.length; x++) System.out.print(arr[x]+" ");
    }
}
