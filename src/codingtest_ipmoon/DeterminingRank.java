package codingtest_ipmoon;

import java.util.*;
import java.util.stream.IntStream;

public class DeterminingRank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int [] arr = new int[l];
        int [] oArr = new int[l];
        for(int i = 0; i <arr.length;i++){
            arr[i] = s.nextInt();
            oArr[i] = 1;
        }
//        for(int j =0; j<arr.length; j++){
//            for(int a = 0; a<arr.length; a++){
//                if(arr[j] > arr[a]){
//                    oArr[a] += 1;
//                }
//            }
//        }
        for(int j =0; j<arr.length; j++){
            int cnt = 1;
            for(int a = 0; a<arr.length; a++){
                if(arr[j] < arr[a]) cnt++;
            }
            oArr[j] = cnt;
        }

        for (int b :oArr) {
            System.out.print(b + " ");
        }
    }
}


