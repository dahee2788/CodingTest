package codingtest_ipmoon;

import java.util.Scanner;
import java.util.Stack;

public class PostfixNotationEvaluation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Stack<Integer> stack = new Stack<>();
        for(Character x : str.toCharArray()){
            if(Character.isDigit(x)) stack.push(Character.getNumericValue(x));
            else {
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                switch (x){
                    case '+':
                        c = a+b;
                        break;
                    case '-':
                        c = a-b;
                        break;
                    case '*':
                        c = a*b;
                        break;
                    case '/':
                        c = a/b;
                        break;
                }
                stack.push(Math.abs(c));
            }
        }

        System.out.println(stack.pop());

    }
}
