package codingtest_ipmoon;

import java.util.Scanner;
import java.util.Stack;

public class IronBar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '(') stack.push(str.charAt(i));
            else {
                stack.pop();
                if(str.charAt(i-1) == '(') {
                    answer += stack.size();
                }else {
                    answer ++;
                }
            }
        }
        System.out.println(answer);

    }
}
