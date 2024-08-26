package codingtest_ipmoon;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParenthesisCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Stack<Character> stack = new Stack<>();
//        for(Character x : str.toCharArray()){
//            if(x == '(') stack.push(x);
//            else if(x == ')') stack.pop();
//            else {
//                if(stack.empty()) System.out.print(x);
//            }
//        }
        solution(str);
    }
    static void solution(String str){
        Stack<Character> stack = new Stack<>();
        for(Character x : str.toCharArray()){
            if(x == ')') {
                while (stack.pop() != '(');
            }
            else stack.push(x);
        }
        for(int i =0; i<stack.size(); i++){
            System.out.print(stack.get(i));
        }
    }

}
