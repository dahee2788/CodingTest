package programmers;

import java.util.Arrays;

public class EmergencyRoom_120835 {
    public static void main(String[] args) {
        int[] emergencyRooms = {3, 76, 24};
        System.out.println(Arrays.toString(solution(emergencyRooms))); // [3, 1
    }

    public static int[] solution(int[] emergency) {

        Emergency[] indexList = new Emergency[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            indexList[i] = new Emergency(i, emergency[i]);
        }
        Arrays.sort(indexList);
        int[] answer = new int[emergency.length];
        for (int i = 0; i < indexList.length; i++) {
            int idx = indexList[i].idx;
            answer[idx] = i + 1;
        }
        return answer;
    }

    static class Emergency implements Comparable<Emergency> {
        int idx;
        int value;

        public Emergency(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Emergency o) {
            return o.value - this.value;
        }
    }
}
