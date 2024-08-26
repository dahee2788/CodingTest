package codingtest_ipmoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoBFS {
    static int m,n;
    static int [][] tomatos, dis;
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        dis = new int[n][m];
        tomatos = new int[n][m];
        for(int i =0; i<n; i++){
            for(int j=0; j < m; j++){
                tomatos[i][j] = s.nextInt();
                if(tomatos[i][j] == 1) queue.offer(new Tomato(i,j));
            }
        }
        TomatoBFS t = new TomatoBFS();
//        t.BFS();
        t.BFS2();
    }

    /* 내 풀이 */
    public void BFS(){
        int l = -1;
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i< size; i++){
                    Tomato tom = queue.poll();
                    for(int j = 0; j < dir.length; j++){
                       int ny = tom.y + dir[j][0];
                       int nx = tom.x + dir[j][1];
                       if( ny > -1 && nx > -1 && ny < n && nx < m && tomatos[ny][nx] == 0){
                           tomatos[ny][nx] = 1;
                           queue.offer(new Tomato(ny,nx));
                       }
                    }
                }
                l++;
            }
        for(int i =0; i<n; i++){
            for(int j=0; j < m; j++){
                if(tomatos[i][j] == 0) {
                   l = -1;
                   break;
                }
            }
        }
        System.out.println(l);
    }
    public void BFS2(){
        while (!queue.isEmpty()){
                Tomato tom = queue.poll();
                for(int j = 0; j < dir.length; j++){
                    int ny = tom.y + dir[j][0];
                    int nx = tom.x + dir[j][1];
                    if( ny > -1 && nx > -1 && ny < n && nx < m && tomatos[ny][nx] == 0){
                        tomatos[ny][nx] = 1;
                        queue.offer(new Tomato(ny,nx));
                        dis[ny][nx] = dis[tom.y][tom.x] + 1;
                    }
                }
        }
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
            for(int j=0; j < m; j++){
                if(tomatos[i][j] == 0) flag = false; /* while문이 끝난 후 0 값이 있다면 == 익지 않은게 있다면 false */
            }
        }
        if(flag){
            for(int i =0; i<n; i++){
                for(int j=0; j < m; j++){
                    answer = Math.max(answer,dis[i][j]);
                }
            }
        }else answer = -1;
        System.out.println(answer);

    }
    static public class Tomato{
        int y;
        int x;

         public Tomato(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}


