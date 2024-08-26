package programmers;

import java.util.Arrays;

public class InterceptionSystem_181188 {
    public static void main(String[] args) {

    }
    public int solution(int[][] targets) {
        int answer = 0;
        // 시작 지점을 기준으로 오름차순 정렬
        Arrays.sort(targets,((o1, o2) -> {return o1[0]-o2[0];}));
        // 미사일 폭격의 공통 범위 구하기
        int s = Integer.MIN_VALUE;
        int e = Integer.MAX_VALUE;
        answer++;
        for(int[] t : targets){
            int cs = t[0];
            int ce = t[1];
            if(cs >= s && e>=ce){
                // 현재 미사일 폭격이 공통 범위 내 일때, 현재 값으로 대입
                s = cs;
                e = ce;
            }
            else if(cs < e && ce >= e){
                // 현재 미사일 폭격이 공통 범위에 걸칠때, 현재 시작값을 대입(사전에 오름차순으로 정렬하였기 때문에 현재 시작값이 더 작은 경우는 없다.)
                s = cs;
            }
            else{
                // 현재 미사일 폭격이 공통 범위를 벗어났을때, answer count++ 해주고, 현재 값으로 대입
                s = cs;
                e = ce;
                answer++;
            }
        }

        return answer;
    }
}
