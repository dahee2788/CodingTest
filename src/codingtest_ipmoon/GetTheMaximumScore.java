package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Scanner;

public class GetTheMaximumScore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int [] dy = new int[m+1];
        ArrayList<ProblemScore> list = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            list.add(new ProblemScore(a,b));
        }

        for(int i = 0; i<list.size(); i++){
            for(int j = m; j>=list.get(i).time; j--){
                dy[j] = Math.max(dy[j],dy[j - list.get(i).time] + list.get(i).score);
            }
        }
        System.out.println(dy[m]);
    }
}
class ProblemScore{
    int score;
    int time;
    public ProblemScore(int score, int time){
        this.score = score;
        this.time = time;
    }
}
