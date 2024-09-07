package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SharedTaxiFare_72413 {
   static int routeLength;
    static int start;
    static ArrayList<ArrayList<Fare>> list = new ArrayList<>();

    public static void main(String[] args) {
        int [][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(6,4,6,2, fares));
    }
    public static int solution(int n, int s, int a, int b, int[][] fares) {

        routeLength = n;
        start = s;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < fares.length; i++) {
            int [] route = fares[i];
            Fare fare = new Fare(route[1], route[2]);
            list.get(route[0]).add(fare);
            Fare fare2 = new Fare(route[0], route[2]);
            list.get(route[1]).add(fare2);
        }
        int answer = Integer.MAX_VALUE;
        int [] together = dijkstra(start);
        for(int i =1; i<=routeLength; i++){
            int [] alone = dijkstra(i);
            // 같이 타고온 금액 + 각자 택시탄 금액 ;
            int fare = together[i] + alone[a] + alone[b];
            answer = Math.min(answer, fare);
        }

        return answer;
    }
    static int[] dijkstra(int start){
        int [] minFare = new int[routeLength+1];
        boolean[] visited = new boolean[routeLength+1];
        PriorityQueue<Fare> pq = new PriorityQueue<>();
        Arrays.fill(minFare, Integer.MAX_VALUE);
        // 시작
        minFare[start] = 0;
        pq.add(new Fare(start, 0));
        while(!pq.isEmpty()){
            Fare currentFare = pq.poll();
            if(visited[currentFare.arrival]) continue;

            visited[currentFare.arrival] = true;
            for(Fare fare : list.get(currentFare.arrival)){
                // 현재 해당 정점으로 향한 택시비보다 더 적을때만
                if(minFare[fare.arrival] > fare.fare + currentFare.fare){
                    minFare[fare.arrival] = fare.fare + currentFare.fare;
                    pq.add(new Fare(fare.arrival, fare.fare + currentFare.fare));
                }
            }
        }


       return minFare;
    }
    public static class Fare implements Comparable<Fare>{
        int arrival;
        int fare;

        public Fare(int arrival, int fare) {
            this.arrival = arrival;
            this.fare = fare;
        }

        @Override
        public int compareTo(Fare o) {
            return this.fare - o.fare;
        }
    }
}
