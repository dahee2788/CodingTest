package programmers;

import java.util.*;

public class OilDrilling_250136 {

    public static void main(String[] args) {
//        int [][] arr = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
//        int [][] arr = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
//        int [][] arr = {{1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1}, {0, 0, 1, 1, 0, 0}};
//        int [][] arr = {
//                {1, 1, 1, 1, 0},
//                        {1, 0, 0, 0, 0},
//                                {0, 0, 0, 1, 1},
//                                        {1, 0, 0, 1, 0},
//                                                {1, 1, 0, 1, 0},
//        };
        int [][] arr = {
                {1, 1, 1, 1},
                        {1, 0, 0, 0},
                                {1, 0, 1, 0},
                                        {1, 0, 0, 0},
                                                {1, 1, 1, 1}};
        System.out.println(solution(arr));
    }
    public static int solution(int[][] land) {
        int n = land.length; // 세로길이
        int m = land[0].length; // 가로길이
        int [] dn = {1,-1,0,0};
        int [] dm = {0,0,1,-1};
        int [] oil = new int[m];
        for(int i = 0; i<m; i++){
            for(int j = 0; j <n;j++){
                if(land[j][i] == 1){
                    Queue<int[]> q = new LinkedList<>();
                    int amount = 1;
                    land[j][i] = 0;
                    q.offer(new int[]{j,i});
                    Set<Integer> set = new HashSet<>();
                    while (!q.isEmpty()){
                        int size = q.size();
                        for(int s = 0; s< size; s++){
                            int [] c = q.poll();
                            set.add(c[1]); // x축의 위치 저장
                            for(int d = 0; d < 4; d++){
                                int nn = c[0] + dn[d];
                                int nm = c[1] + dm[d];
                                if(nn > -1 && nm > -1 && nn < n && nm < m && land[nn][nm] == 1){
                                    amount++;
                                    land[nn][nm] = 0;
                                    q.offer(new int[]{nn,nm});
                                }
                            }
                        }
                    }
                    for(int st : set) oil[st] += amount; // 방문했었던 석유 위치에 저장량 합산
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int o : oil) answer = Math.max(answer,o);
        return answer;
    }

}
