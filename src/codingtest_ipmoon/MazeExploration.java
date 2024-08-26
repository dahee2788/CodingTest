package codingtest_ipmoon;

import java.util.Scanner;

public class MazeExploration {
    static int n = 7;
    static int [][] maze = new int[n][n];
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static int answer = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                maze[i][j] = s.nextInt();
            }
        }
        MazeExploration t = new MazeExploration();
        maze[0][0] = 1; //  출발 지점 체크
        t.DFS(0,0);
        System.out.println(answer);

    }
    public void DFS(int y, int x){
        if(y == x && y == n-1) answer++;
        else {
            for(int i = 0; i < dir.length; i++){
                int [] arr = dir[i];
                int cy = y + arr[0];
                int cx = x + arr[1];
                if(cy > -1 && cx > -1 && cy < n && cx < n && maze[cy][cx] == 0){
                        maze[cy][cx] = 1;
                        DFS(cy,cx);
                        maze[cy][cx] = 0;
                }
            }
        }

    }
}
