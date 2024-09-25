package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class farthestNode_49189 {
    public static void main(String[] args) {
        int n  = 6;
        int [][] edges = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edges));
    }
    public static int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());
        for(int []e : edge){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int answer = bfs(adj);
        return answer;
    }
    public static int bfs(ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, -1);

        queue.offer(1);
        distance[1] = 0;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            for(int node : adj.get(currentNode)){
                if(distance[node] == -1) {
                    distance[node] = distance[currentNode] + 1;
                    queue.offer(node);
                }
            }
        }
        int MaxDistance = -1;
        for(int d : distance ){
            if(MaxDistance < d) MaxDistance = d;
        }
        int answer = 0;
        for(int d : distance ){
            if(MaxDistance == d) answer++;
        }

        return answer;
    }
}
