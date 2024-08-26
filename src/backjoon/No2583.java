package backjoon;

import java.util.*;

public class No2583 {
    static int [][] arr;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int k = s.nextInt();
        arr = new int [m][n];
        int [][] visit = new int[m][n];
        ArrayList<Integer> answerArr = new ArrayList<>();
        for(int i = 0; i<k; i++){
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            for(int y = y1; y < y2; y++){
                for(int x = x1; x<x2; x++){
                    arr[y][x] = 1;
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    answerArr.add(DFS(i,j));
                }
            }
        }
        Collections.sort(answerArr); // 오름차순 정렬
        System.out.println(answerArr.size());
        answerArr.forEach(o-> System.out.print(o + " "));
    }
  static public int DFS(int m, int n){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0}; // 위아래좌우 방향
        int size = 0;
        Queue<int[]> q = new LinkedList<>();
        size++;
        arr[m][n] = 1;
        q.offer(new int[]{m,n});
        while (!q.isEmpty()){
            int length = q.size();
            for(int i =0; i<length; i++){
                int []blankArr = q.poll();
                for(int j = 0; j<4; j++){
                    int ny = blankArr[0] + dy[j];
                    int nx = blankArr[1] + dx[j];
                    if(ny > -1 && nx > -1 && ny < arr.length && nx < arr[0].length && arr[ny][nx] == 0){
                        arr[ny][nx] = 1;
                        size++;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }

        }
        return size;
    }
}
