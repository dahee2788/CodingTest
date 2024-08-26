package codingtest_ipmoon;

import java.util.*;

public class Wedding {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        List<Timing> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            Timing t = new Timing(a,'s');
            Timing t2 = new Timing(b,'e');
            list.add(t);
            list.add(t2);
        }
        Collections.sort(list);
        for (Timing t :list) {
            if(t.status == 's') cnt++;
            else if(t.status == 'e') cnt--;
            answer = Math.max(answer,cnt);
        }
        System.out.println(answer);
    }
}
class Timing implements Comparable<Timing>{
    int time;
    char status;

    public Timing(int time,char status){
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Timing o) {
        if(this.time == o.time) return this.status - o.status;
        else return this.time - o.time;
    }
}