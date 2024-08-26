package codingtest_ipmoon;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = Integer.parseInt(s.nextLine());
        int[]a = new int[len];
        int[]b = new int[len];
        for (int i = 0; i<a.length; i++){
            a[i] = s.nextInt();
        }
        for (int i = 0; i<b.length; i++){
            b[i] = s.nextInt();
            System.out.println(solution(a[i], b[i]));
//            if(a[i] == b[i]) System.out.println("D");
//            else{
//                switch (a[i]){
//                    case 1 :
//                        if(b[i] == 2) System.out.println("B");
//                        else System.out.println("A");
//                        break;
//                    case 2 :
//                        if(b[i] == 3 ) System.out.println("B");
//                        else System.out.println("A");
//                        break;
//                    case 3 :
//                        if(b[i] == 1 ) System.out.println("B");
//                        else System.out.println("A");
//                        break;
//                }
//            }
        }
    }
    public static String solution(int a, int b){
        String answer = "";
        if(a == b) answer = "D";
        else if(a == 1 && b == 3) answer = "A";
        else if(a == 2 && b == 1) answer = "A";
        else if(a == 3 && b == 2) answer = "A";
        else answer = "B";
        return answer;
    }
}
