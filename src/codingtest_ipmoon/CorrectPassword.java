package codingtest_ipmoon;

import java.util.Scanner;
import java.util.Stack;

public class CorrectPassword {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int sum = 0;
        for(Character c : str.toCharArray()){
            if(c == '(') sum++;
            else {
                if(sum == 0) {
                    System.out.println("NO");
                    return;
                }else sum--;
            }
        }
//        System.out.println(sum == 0?"YES":"NO");
        System.out.println(solution(str));
    }
    static String solution(String str){
        Stack<Character> s = new Stack<>();
        for(Character c : str.toCharArray()){
            if(c == '(') s.push(c);
            else {
                if(s.empty()) return "NO";
                else s.pop();
            }
        }
        return s.empty()?"YES":"NO";
    }
}
