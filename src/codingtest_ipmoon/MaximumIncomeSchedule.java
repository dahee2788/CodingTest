package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumIncomeSchedule {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Lecture> list = new ArrayList<>();
        int n = s.nextInt();
        int MaxDay = 0;
        for (int i = 0; i < n; i++) {
            int w = s.nextInt();
            int d = s.nextInt();
            Lecture l = new Lecture(w, d);
            list.add(l);
        }
        Collections.sort(list);
        MaxDay = list.get(0).inDay;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int wageSum = 0;
        int idx = 0;

        for (int i = MaxDay; i >= 1; i--) {
            for (; idx < n; idx++) {
                if (list.get(idx).inDay < i) break;
                pq.add(list.get(idx).wage);
            }
            if (!pq.isEmpty()) wageSum += pq.poll();
        }
        System.out.println(wageSum);
    }
}
class Lecture implements Comparable<Lecture>{
    int wage;
    int inDay;

    public Lecture(int wage, int inDay){
        this.wage = wage;
        this.inDay = inDay;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.inDay - this.inDay; // 내림차순
    }
}
