package codingtest_ipmoon;

import java.util.*;

public class WonderLand2 {
        static int [] chk;
        static int sum = 0;
        static PriorityQueue<City2> q = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();

        chk = new int[v+1];
        List<ArrayList<City2>> list = new ArrayList<>();
        for (int i = 0; i<=v; i++) list.add(new ArrayList<City2>());
        for(int i = 0; i<e; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            list.get(a).add(new City2(b,c));
            list.get(b).add(new City2(a,c));
        }
        q.offer(new City2(1,0));
        while (!q.isEmpty()){
            City2 cc = q.poll(); // 코스트가 제일 낮은 거 뽑기
            if(chk[cc.v2] == 0){ // 연결된 거면 들리지 않기
                chk[cc.v2] = 1;
                sum += cc.cost;
                for(City2 vc : list.get(cc.v2)){
                    if(chk[vc.v2] == 0) q.offer(new City2(vc.v2,vc.cost)); // 정점에서 갈 수 있는 경로 모두 큐에 넣고
                }
            }
        }

        System.out.println(sum);

    }

}
class City2 implements Comparable<City2>{
    int v2;
    int cost;
    public City2(int v2, int cost){
        this.v2  = v2;
        this.cost  = cost;
    }

    @Override
    public int compareTo(City2 o) {
        return this.cost - o.cost;
    }
}


