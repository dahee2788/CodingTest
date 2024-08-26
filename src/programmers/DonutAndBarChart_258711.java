package programmers;

import java.util.HashMap;
import java.util.Map;

public class DonutAndBarChart_258711 {
    public static void main(String[] args) {

        int [][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        int []arr = solution(edges);
        for(int a : arr) System.out.println(a);
    }
    public static int[] solution(int[][] edges) {
        /* 정점별 나가는 간선과 들어오는 간선의 개수를 담아둘 map 생성 */
        Map<Integer,Integer> out = new HashMap<>();
        Map<Integer,Integer> in = new HashMap<>();
        int newNode = -1;
        int donut = 0;
        int bar = 0;
        int eight = 0;

        /* 간선들을 for문돌면서 각 정점의 나가는 간선, 들어오는 간선의 개수를 저장한다
        *  map.getOrDefault(d,n) :  map에서 key가 d인 value를 리턴하는데 만약 d가 없으면 n 리턴
        */
        for(int [] e : edges){
            out.put(e[0],out.getOrDefault(e[0],0) + 1);
            in.put(e[1],in.getOrDefault(e[1],0) + 1);
        }
        for(int node : out.keySet()){
            if(out.get(node) > 1) {
                /* 나가는 간선은 2개이상이지만, 들어오는 간선이 없는 정점 : 추가생성 정점 */
                if(!in.containsKey(node)) newNode = node;
                /* 나가는 간선이 2개이상이고 들어오는 간선도 1개 이상 : 8그래프의 가운데 정점 */
                else eight++;
            }
        }
        /* 나가는 간선이 없는 정점 : 막대 그래프의 마지막 정점 */
        for(int node : in.keySet()){
            if(!out.containsKey(node)) bar++;
        }
        /* 추가 생성 정점의 간선 개수는 도넛, 막대, 8자 그래프 수의 합과 같음 */
        donut = out.get(newNode) - bar - eight;

        int[] answer = {newNode,donut,bar,eight};
        return answer;
    }
}
