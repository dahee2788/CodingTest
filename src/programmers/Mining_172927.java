package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Mining_172927 {
    static ArrayList<String> tiredness = new ArrayList<>(Arrays.asList("diamond", "iron", "stone"));
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] picks = new int[]{1, 3, 2};
        String[] minerals = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {

        DFS(picks, minerals, 0, 0);
        return answer;

    }

    public static void DFS(int[] picks, String[] minerals, int idx, int result) {
        int mineralLength = minerals.length;
        int re = 0;

        // 사용할 수 있는 곡괭이가 없을 때
        if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            answer = Math.min(answer, result);
            return;
        }
        // 3개의 곡괭이 중에 1개 선택
        for (int i = 0; i < 3; i++) {
            re = result;
            if (picks[i] > 0) {
                // 1개의 곡괭이가 광물 5개 캘 수 있다.
                for (int j = 0; j < 5; j++) {
                    // 캘 광물이 아직 남아있다면
                    if (idx + j < mineralLength) {
                        int findMineralIdx = tiredness.indexOf(minerals[idx + j]);
                        if (i >= findMineralIdx) re += Math.pow(5, i - findMineralIdx);
                        else re++;
                    } else {
                        // 광물을 다 캤다면
                        answer = Math.min(answer, re);
                        return;
                    }
                }
                // 사용한 광물을 빼주고 dfs 실행
                picks[i]--;
                DFS(picks, minerals, idx + 5, re);
                // 다른 케이스를 위해 원복
                picks[i]++;
            }

        }
    }
}
