package codingtest_ipmoon;

import java.util.*;

public class KthLargestNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++ ) arr[i] = s.nextInt();

        Set<Integer> treeSet = new TreeSet<>(Collections.reverseOrder()); //  자동으로 내림차순

        for(int a = 0; a<n; a++){
            for(int b = 0; b <n; b++){
                for(int c = 0; c < n; c++){
                    if(a != b && b != c && a != c) treeSet.add(arr[a]+arr[b]+arr[c]);
                }
            }
        }
        Object [] trra = treeSet.toArray();
        System.out.println(k > n || k < 1?-1:trra[k-1]);



    }
}
