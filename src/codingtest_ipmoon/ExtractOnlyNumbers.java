package codingtest_ipmoon;

import java.util.Scanner;

public class ExtractOnlyNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(solution(str));
        System.out.println(solution2(str));

        str = str.replaceAll("[^0-9]","");
        int i = Integer.valueOf(str);
        System.out.println(i);

    }
    static int solution(String str){
        int answer = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                answer = answer * 10 + (str.charAt(i) - 48);
            }
        }
        return answer;
    }
    static int solution2(String str){
        String answer = "";
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i)))answer+=str.charAt(i);
        }
        return Integer.valueOf(answer);
    }
}


