package programmers;

import java.util.ArrayList;
import java.util.List;

public class SheepAndWolves_92343 {
    static int[] infoArray;
    static List<List<Integer>> tree;
    static int maxSheep = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}; // 주어진 정보
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}; // 주어진 간선
        System.out.println(solution(info, edges));
    }

    public static int solution(int[] info, int[][] edges) {
        infoArray = info;
        tree = new ArrayList<>();
        for (int i = 0; i < info.length; i++) tree.add(new ArrayList<>());
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> nextVisited = new ArrayList<>();
        nextVisited.add(0);
        dfs(0, 0, 0, nextVisited);
        int answer = maxSheep;
        return answer;
    }

    static void dfs(int node, int sheepCount, int wolfCount, ArrayList<Integer> nextVisited) {

        if (infoArray[node] == 0) {
            sheepCount++;
        } else {
            wolfCount++;
        }

        if (sheepCount <= wolfCount) {
            return;
        }
        maxSheep = Math.max(maxSheep, sheepCount);

        // 현재 지점에서 방문 가능할 노드 리스트에 저장
        ArrayList<Integer> temp = new ArrayList<>();
        // 넘어온 리스트는 모두 저장
        temp.addAll(nextVisited);
        // 현재 노드 삭제
        temp.remove(Integer.valueOf(node));
        // 현재 노드 하위에 자식이 있으면 temp에 저장
            for (int nextNode : tree.get(node)) {
                temp.add(nextNode);
            }
        // temp에 담긴 노드 모두 방문
        for (int nextNode : temp) {
            dfs(nextNode, sheepCount, wolfCount, temp);
        }
    }
}
