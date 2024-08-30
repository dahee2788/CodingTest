package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot_169199 {
    static int [][] visitBoard;
    static int [] dy = {0,0,1,-1};
    static int [] dx = {1,-1,0,-0};
    static int answer = -1;
    public static void main(String[] args) {
        String[] board = new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }
    public static int solution(String[] board) {
        int m = board.length;
        int n = board[0].length();
        visitBoard = new int[m][n];
        int [] start = new int[]{0,0};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if('R' == board[i].charAt(j)) {
                    start = new int[]{i,j};
                    visitBoard[i][j] = 1;
                }
            }
        }
        // y, x, count
        queue.offer(new int[]{start[0],start[1],0});

        while (!queue.isEmpty()) {

            int[] point = queue.poll();
            int y = point[0];
            int x = point[1];
            int count = point[2];

            // 도착지점이면 answer에 값 대입
            if(board[y].charAt(x) == 'G') {
                answer = count;
                return answer;
            }

            // 상하좌우 방향 이동 해보기
            for (int i = 0; i < 4; i++) {
               int nx = x;
               int ny = y;
               while (ny > -1 && ny < board.length && nx > -1 && nx < board[0].length()
               && board[ny].charAt(nx) != 'D') {
                   ny += dy[i];
                   nx += dx[i];
               }
               ny -= dy[i];
               nx -= dx[i];

               // 방문한 적이 있거나 처음 시작한 위치와 같은 위치면 continue
               if(visitBoard[ny][nx] == 1 || y == ny && x == nx) continue;

               // 처음 방문한 거라면 체크하고
               visitBoard[ny][nx] = 1;

               // 다음 레벨로 넘어감
               queue.offer(new int[]{ny,nx ,count+1});
            }
        }
        return answer;
    }
}
