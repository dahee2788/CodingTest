package codingtest_ipmoon;

import java.util.*;

public class MergeTwoArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        List<Integer> arr = new ArrayList<>();
        int[]arr1 = new int[n1];
        for(int i = 0; i<n1; i++){
            arr1[i] = s.nextInt();
            arr.add(arr1[i]);
        }
        int n2 = s.nextInt();
        int[]arr2 = new int[n2];
        for(int i = 0; i<n2; i++){
            arr2[i] = s.nextInt();
            arr.add(arr2[i]);
        }
        Collections.sort(arr);
//        for (int a :
//             arr) {
//            System.out.print(a + " ");
//        }
        solution(arr1,arr2);
    }
 static void solution(int [] a , int [] b){
    int an = a.length;
    int bn = b.length;
    List<Integer> list = new ArrayList<>();
    int p1=0, p2=0;
    while (p1 < an && p2 < bn){
        if(a[p1] < b[p2]) list.add(a[p1++]);
        else list.add(b[p2++]);
    }
    while (p1<an) list.add(a[p1++]);
    while (p2<bn) list.add(b[p2++]);
     for (int i :list) {
         System.out.print(i + " ");
     }
 }
}
