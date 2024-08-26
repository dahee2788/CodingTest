package codingtest_ipmoon;

import java.util.Scanner;

public class ScoreCalculation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int[]arr = new int[l];
        int score = 0;
        int sameScore = 0;
        for(int i = 0; i<l; i++){
            int c = s.nextInt();
            arr[i] = c;
            if(c == 1) {
                sameScore++;
                score += sameScore;
            }
            else {
                sameScore = 0;
            }
        }
        System.out.println(score);
    }
}
