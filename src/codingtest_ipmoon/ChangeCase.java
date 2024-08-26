package codingtest_ipmoon;

import java.util.Scanner;

public class ChangeCase {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(changeCase(s));
    }
    static String changeCase(String input){
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < input.length(); i++){
            if(Character.isUpperCase(input.charAt(i))) res.append(Character.toLowerCase(input.charAt(i)));
            if(Character.isLowerCase(input.charAt(i))) res.append(Character.toUpperCase(input.charAt(i)));
        }
        return res.toString();
    }
}
