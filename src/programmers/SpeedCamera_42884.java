package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpeedCamera_42884 {
    public static void main(String[] args) {
        int[][] r = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(solution(r));
    }

    public static int solution(int[][] routes) {
        List<CarRoute> list = new ArrayList<>();
        for (int[] r : routes) {
            CarRoute c = new CarRoute(r[0], r[1]);
            list.add(c);
        }
        Collections.sort(list);
        int count = 0;
        int startRange = Integer.MIN_VALUE;
        int endRange = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                startRange = list.get(i).start;
                endRange = list.get(i).end;
                count++;
                continue;
            } else {
                // start가 range에 포함되는지
                int start = list.get(i).start;
                int end = list.get(i).end;
                if (start > endRange) {
                    startRange = start;
                    endRange = end;
                    count++;
                } else if (start > startRange && end < endRange) {
                    startRange = start;
                    endRange = end;
                }
            }
        }

        int answer = count;
        return answer;
    }
}

class CarRoute implements Comparable<CarRoute> {
    int start;
    int end;

    public CarRoute(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(CarRoute o) {
        return this.start - o.start;
    }
}