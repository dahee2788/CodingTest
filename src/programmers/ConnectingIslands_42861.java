package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectingIslands_42861 {
    public static void main(String[] args) {
        int[][]arr = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int n = 4;
        System.out.println(solution(n,arr));

    }
    public static int solution(int n, int[][] costs) {
        ArrayList<ArrayList<Bridge>> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {bridges.add(new ArrayList<>()); }
        for (int[] cost : costs) {
            int from = cost[0], to = cost[1], c = cost[2];
            bridges.get(from).add(new Bridge(to, c));
            bridges.get(to).add(new Bridge(from, c));
        }

        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        visited[0] = true;
        for(Bridge bridge : bridges.get(0)) {
            pq.offer(bridge);
        }
        while(!pq.isEmpty()) {
            Bridge bridge = pq.poll();
            if(!visited[bridge.to]){
                visited[bridge.to] = true;
                totalCost += bridge.cost;
                for(Bridge next : bridges.get(bridge.to)) {
                    pq.offer(next);
                }
            }
        }

        int answer = totalCost;
        return answer;
    }
}

class Bridge implements Comparable<Bridge> {
    int to;
    int cost;

    public Bridge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bridge o) {
        return this.cost - o.cost;
    }
}
