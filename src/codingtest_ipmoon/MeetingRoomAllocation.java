package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MeetingRoomAllocation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cnt = 0;
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int start = s.nextInt();
            int end = s.nextInt();
            Meeting m = new Meeting(start,end);
            list.add(m);
        }
        int maxtime = 0;
        Collections.sort(list);
        for(int i = 0; i<list.size(); i++){
            Meeting m = list.get(i);
            if(maxtime <= m.startTime){
                cnt++;
                maxtime = m.endTime;
            }
        }
        System.out.println(cnt);
    }
}
class Meeting implements Comparable<Meeting> {
    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.endTime == o.endTime) return this.startTime - o.startTime;
        return this.endTime - o.endTime;
    }
}
