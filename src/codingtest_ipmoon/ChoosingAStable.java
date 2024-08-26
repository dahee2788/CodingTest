package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Scanner;

public class ChoosingAStable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        int [] arr = new int[n];
        for(int i =0 ; i< n; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);
        int answer = 0;

        int lt = 1;
        int rt = arr[n-1];
        while (lt <= rt){
            int mid = (lt + rt) /2;
            if(count(mid,arr) >= c){ // 말을 c 보다 더 많이 배치할 수 있다면 간격이 더 널널 할 수 있다는 뜻 그래서 >=
                answer = mid;
                lt = mid + 1; // 더 넓게 배치 할 수 있기때문에 더 작은 mid는 볼 필요 없음 그래서 lt = mid + 1
            }else rt = mid -1; // 배치할 수 있는 말의 수가 c보다 적다면 더 적은 수로 적용. 그래서 rt = mid -1;

        }
        System.out.println(answer);
    }

    static int count(int interval, int [] arr ){
        int horse = 1;
        int end = arr[0];
        for(int i =1;  i < arr.length; i++){
            if(arr[i] - end >= interval){
                horse++;
                end = arr[i];
            }
        }
        return horse;
    }
}
