package codingtest_ipmoon;

import java.util.*;

public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[]cArray = str.split("");
        StringBuilder sb = new StringBuilder();
        for(String c : cArray){
            if(sb.indexOf(c) == -1) sb.append(c);
        }
//        System.out.println(sb.toString());
        System.out.println(solution(str));
    }

    static String solution(String str){
        String answer = "";
        for(int i = 0; i<str.length(); i++){
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }
}
