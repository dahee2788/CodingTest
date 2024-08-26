package backjoon;

import java.util.*;

public class No2667 {
    static int n;
    static int [][] map;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        map = new int[n][n];
        ArrayList<Integer> answerArr = new ArrayList<>();
        for(int i = 0; i< n; i++){
           String intline = s.next();
           for(int j = 0; j< n; j++){
               map[i][j] = Integer.valueOf(intline.charAt(j)+ "");
           }
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++) {
                if(map[i][j] == 1) answerArr.add(dfs(i,j));
            }
        }
        Collections.sort(answerArr);
        System.out.println(answerArr.size());
        answerArr.forEach(o-> System.out.println(o));
    }
    static int dfs(int i , int j ){
        int []dx = {0,0,-1,1};
        int []dy = {-1,1,-0,0};
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        map[i][j] = 0;
        count++;
        q.offer(new int[]{i,j});
        while (!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s<size; s++){
                int []cMap = q.poll();
                for(int d = 0; d<4; d++){
                    int ny = cMap[0]+dy[d];
                    int nx = cMap[1]+dx[d];
                    if(ny > -1 && nx > -1 && ny < n && nx < n && map[ny][nx] == 1){
                            map[ny][nx] = 0;
                            count++;
                            q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
        return count;
    }
}
