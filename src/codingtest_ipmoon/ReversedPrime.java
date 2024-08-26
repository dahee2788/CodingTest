package codingtest_ipmoon;

import java.util.Scanner;

public class ReversedPrime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int [] arr = new int[len];
//        for (int i = 0; i < len; i++){
//            StringBuilder sb = new StringBuilder(s.next());
//            arr[i] = Integer.parseInt(sb.reverse().toString());
//            if( arr[i] <= 1) continue;
//            int [] iArr = new int[arr[i] + 1];
//            for(int j = 2; j < iArr.length; j++){
//                if(j == arr[i] && iArr[j] == 0) System.out.print(arr[i] + " ");
//                int r = arr[i]/j;
//                for(int a = 1; a<=r; a++){
//                    iArr[a*j] = 1;
//                }
//            }
//        }
        for (int i = 0; i < len; i++){
            int num = s.nextInt();
            num = reverseNum(num);
            if(isPrime(num)) System.out.print(num + " ");
        }
    }
    static int reverseNum(int num){
        int res = 0;
        int tmp = num;
        while (tmp > 0) {
            int t = tmp % 10; // 나머지
            res = (res * 10) + t;
            tmp = tmp / 10;
        }
        return res;
    }
    static boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i =2; i<num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}
