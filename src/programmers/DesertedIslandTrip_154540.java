package programmers;

import java.util.*;

public class DesertedIslandTrip_154540 {

    static String [][] map;
    public static void main(String[] args) {
//        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        String[] maps = {"XXX","XXX","XXX"};
        int []answer = solution(maps);
        for(int a : answer) {
            System.out.println(a);
        }
    }
    public static int[] solution(String[] maps) {

        map = new String[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j) + "";
            }
        }

        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(!"X".equals(map[i][j])) {
                    int meal = Integer.parseInt(map[i][j]);
                    map[i][j] = "X";
                   int mealSum =  bfs(new int[]{i,j}, meal);
                    answerList.add(mealSum);

                }
            }
        }

        Collections.sort(answerList);
        int[] answer;
        if(!answerList.isEmpty()) answer = answerList.stream().mapToInt(i -> i).toArray();
        else answer = new int[]{-1};
        return answer;
    }
    static int  bfs(int[] start ,int meal){

        int[]dy = {0,0,1,-1};
        int[]dx = {1,-1,0,0};
        int mealSum = meal;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0],start[1]});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for(int j = 0; j < dy.length; j++) {
                    int newY = current[0] + dy[j];
                    int newX = current[1] + dx[j];
                    if(newY > -1 && newY < map.length && newX > -1 && newX < map[0].length && !map[newY][newX].equals("X")) {
                        mealSum +=Integer.parseInt(map[newY][newX]);
                        map[newY][newX] = "X";
                        queue.offer(new int[]{newY,newX});
                    }
                }
            }
        }
       return mealSum;
    }
}
