package codingtest_ipmoon;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
//        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder(str).reverse();
        String isSame = "NO";
        if(str.equalsIgnoreCase(sb.toString())) isSame = "YES";
//        System.out.println(isSame);
        System.out.println(solution(str));
    }

    static String solution(String str){
        String answer = "YES";
        str = str.toLowerCase();
        for (int i = 0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt((str.length() -1) -i)) answer = "NO";
        }
        return answer;
    }
}
