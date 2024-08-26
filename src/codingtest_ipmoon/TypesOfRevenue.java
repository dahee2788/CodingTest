package codingtest_ipmoon;

import java.util.*;

public class TypesOfRevenue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = s.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        int lt = 0 , rt = 0;
        while (rt < n){
            if(rt - lt < k){
                map.put(arr[rt],map.getOrDefault(arr[rt],0) + 1);
                rt++;
            }
            else {
                System.out.print(map.size()+" ");
                if(map.get(arr[lt]) == 1) map.remove(arr[lt]);
                else map.put(arr[lt],map.get(arr[lt]) - 1);

                lt++;
                map.put(arr[rt],map.getOrDefault(arr[rt],0) + 1);
                rt++;
            }
        }
        System.out.print(map.size()+" ");
        for(int x : solution(n,k,arr)) System.out.print(x + " ");

    }
    static ArrayList<Integer> solution(int n, int k, int[]arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < k-1; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int lt = 0;
        for(int rt = k-1; rt < n; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt],0) +1);
            answer.add(map.size());
            map.put(arr[lt],map.get(arr[lt]) -1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
}
