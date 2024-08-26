package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Scanner;

public class FindingCommonElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] a = new int[n];
        for(int i = 0; i<n; i++){
            a[i] = s.nextInt();
        }
        int m = s.nextInt();
        int [] b = new int[m];
        for(int i = 0; i<m; i++){
            b[i] = s.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int pa = 0, pb = 0;
        while (pa < n && pb < m){
            // a 가 더 작으면? a idx 증가
            if(a[pa] < b[pb]) pa++;
            else if(a[pa] > b[pb]) pb++;
            else{
                System.out.print(a[pa] + " ");
                pa++;
                pb++;
            }
        }
    }
}
