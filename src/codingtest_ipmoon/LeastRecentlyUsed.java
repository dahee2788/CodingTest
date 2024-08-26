package codingtest_ipmoon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i  = 0; i<n; i++) arr[i] = scanner.nextInt();
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i =0; i<n; i++){
            int x = arr[i];
            if(!ad.contains(x)){
                if(!(ad.size() < s)) ad.pollLast();
                ad.addFirst(x);
            }
            else {
                ArrayDeque<Integer> tmp = new ArrayDeque<>();
                while (true){
                    int a = ad.pollFirst();
                    if(x == a) {
                        tmp.forEach(o-> ad.addFirst(o)); // tmp 에서 foreach 하면 0 index 부터
                        ad.addFirst(a);
                        break;
                    }else tmp.addFirst(a);
                }
            }
        }
//        ad.forEach(o-> System.out.print(o + " "));
        solution(s,n,arr);
    }

    static void solution(int s, int n, int [] arr){
        int [] sArr = new int[s];
        for(int x : arr){
            int pos = -1;
            for(int i = 0; i < s; i++) if(x == sArr[i]) pos = i;
            if(pos == -1){
                for(int j = s -1; j>0; j--) sArr[j] = sArr[j-1];
            }else {
                for(int j = pos; j>0; j--) sArr[j] = sArr[j-1];
            }
            sArr[0] = x;
        }
        for(int x : sArr) System.out.print(x + " ");
    }
}
