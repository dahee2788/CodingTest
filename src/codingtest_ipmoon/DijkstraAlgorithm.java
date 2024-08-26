package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgorithm {
    static int o = 0;
    static int answer = Integer.MAX_VALUE;
    static int [] chk;
    static int [] dis;
    static ArrayList<ArrayList<WeightNode>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        chk= new int[n+1];
        dis= new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i <=n;i++) list.add(new ArrayList<WeightNode>());
        for(int i = 0; i < m; i++){
            int start = s.nextInt();
            int a = s.nextInt();
            int w = s.nextInt();
            WeightNode wn = new WeightNode(a,w);
            list.get(start).add(wn);
        }
        DijkstraAlgorithm t = new DijkstraAlgorithm();
//        for(int i =2; i<=n; i++){
//            o = i;
//            chk[1] = 1;
//            t.DFS(1,0);
//            System.out.println(i + " : " +(answer == Integer.MAX_VALUE? "impossible":answer));
//            answer = Integer.MAX_VALUE;
//        }
        t.Solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }
    void DFS(int v, int sum){
        if(v == o) {
            answer = Math.min(sum,answer);
        }else {
            for(WeightNode wn: list.get(v)){
                if(chk[wn.arrival] == 0){
//                    sum += wn.weight;
                    chk[wn.arrival] = 1;
                    DFS(wn.arrival,sum + wn.weight);
                    chk[wn.arrival] = 0;

                }

            }
        }
    }
    void Solution(int v){
        PriorityQueue<WeightNode> wq = new PriorityQueue<>();
        wq.offer(new WeightNode(v,0));
        dis[v] = 0;
        while (!wq.isEmpty()){
            WeightNode temp = wq.poll();
            int now = temp.arrival;
            int nowCost = temp.weight;
            if(dis[now] < nowCost) continue; // 최소값을 구하는 것이기 때문에 더 크면 처리 하지 않음
            for(WeightNode wn : list.get(now)){
                if(dis[wn.arrival] > wn.weight + nowCost){
                    dis[wn.arrival] = wn.weight + nowCost;
                    wq.offer(new WeightNode(wn.arrival,wn.weight + nowCost)); // 현재 정점까지의 누적합을 구하고, 다시 하위에 노선이 있는지 탐색하기 위해, 큐에 넣기
                }
            }
        }
    }

}

class WeightNode implements Comparable<WeightNode>{
    Integer arrival;
    int weight;

    public WeightNode(Integer arrival, int weight){
        this.arrival = arrival;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightNode o) {
        return this.weight - o.weight;
    }
}
