package codingtest_ipmoon;

import java.util.Scanner;

public class IslandNationOfIreland {
    static int n,answer;
    static int [][] islandMap;
    static int [][] dir = {{-1,0}, {1, 0}, {0, -1}, {0 ,1},{-1,-1},{-1,1},{1,1},{1,-1}};
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        islandMap  = new int[n][n];
        for(int i = 0; i< n ; i++){
            for(int j = 0; j < n; j++){
                islandMap[i][j] = s.nextInt();
            }
        }
        IslandNationOfIreland t = new IslandNationOfIreland();
        t.solution();
        System.out.println(answer);
    }
    public  void solution(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(islandMap[i][j] == 1) {
                    answer++;
                    islandMap[i][j] = 0;
                    DFS(i,j);
                }
            }
        }
    }
    public  void DFS(int y, int x){
            for(int l = 0; l<dir.length; l++){
                int ny = y + dir[l][0];
                int nx = x + dir[l][1];
                if(ny > -1 && nx > -1 && ny < n && nx < n && islandMap[ny][nx] == 1){
                    islandMap[ny][nx] = 0;
                    DFS(ny,nx);
                }
            }
    }
}
