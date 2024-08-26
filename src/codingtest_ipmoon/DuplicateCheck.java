package codingtest_ipmoon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DuplicateCheck {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String answer = "U";
        int [] arr = new int[n];
        for(int i = 0; i< n; i++) arr[i] = s.nextInt();
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i =0; i<n; i++){
            int x = arr[i];
            if(ad.contains(x)){
                answer = "D";
                break;
            }else ad.addFirst(x);
        }
//        System.out.println(answer);
        System.out.println(solution(n,arr));
    }
    static String solution(int n , int [] arr){
        String answer = "U";
        Arrays.sort(arr);
        for(int i = 0; i<n-1; i++){
            if(arr[i] == arr[i+1]) return "D";
        }
            return answer;
    }
}
