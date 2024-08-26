package codingtest_ipmoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String str = s.nextLine();
        String answer = "";

        Queue<Character> qa = new ArrayDeque<>();
        Queue<Character> qstr = new ArrayDeque<>();
        for(Character x : a.toCharArray()) qa.offer(x);
        for(Character x : str.toCharArray()) qstr.offer(x);
        int l = str.length();
        for(int i = 0; i< l; i++){
            Character x = qstr.poll();
            if(qa.contains(x)){
                qstr.offer(x);
            }
        }
        if(qa.toString().equals(qstr.toString())) answer = "YES";
        else answer = "NO";
        System.out.println(answer);
        System.out.println(solution(a,str));

    }
    static String solution(String need, String plan){
        String answer = "YES";
        Queue<Character> q = new ArrayDeque<>();
        for(Character x : need.toCharArray()) q.offer(x);
        for(Character x : plan.toCharArray()){
            if(q.contains(x)){
                if(x != q.poll()) return "NO";
            }
        };
        return answer;
    }
}
