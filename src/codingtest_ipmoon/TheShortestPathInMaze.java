package codingtest_ipmoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheShortestPathInMaze {
    static int n = 7;
    static int [][] maze = new int[n][n];
    static int [][] dis = new int[n][n];
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int answer = -1;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                maze[i][j] = s.nextInt();
            }
        }
        TheShortestPathInMaze t = new TheShortestPathInMaze();

        t.BFS(0,0);
        System.out.println(answer);
    }
    public void BFS(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        maze[0][0] =1;
        int [] arr = {y,x};
        queue.offer(arr);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i< size; i++){
                int [] cArr = queue.poll();
                if(cArr[0] == cArr[1] && cArr[0] == n-1){
                    answer = dis[cArr[0]][cArr[1]];
                    break;
                }
                else {
                    for (int j = 0; j < dir.length; j++){
                        int ny = cArr[0] + dir[j][0];
                        int nx = cArr[1] + dir[j][1];
                        if(ny > -1 && nx > -1 && ny < n && nx < n && maze[ny][nx] == 0 && dis[ny][nx] == 0){
                            dis[ny][nx] = dis[cArr[0]][cArr[1]] + 1;
                            queue.offer(new int [] {ny,nx});
                        }
                    }
                }
            }
        }
    }
}
