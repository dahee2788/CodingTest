package codingtest_ipmoon;

import java.util.Scanner;

public class ReverseTheWord {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i<n; i++){
            String str = s.nextLine();
//            char[] cArray = str.toCharArray();
//            for (int c = cArray.length -1; c>=0; c--){
//                System.out.print(cArray[c]);
//            }
            System.out.println(solution2(str));

        }
    }
    static String solution(String str){
        return new StringBuilder(str).reverse().toString();
    }
    static String solution2(String str){
        char[] cArray = str.toCharArray();
        int lt = 0 ;
        int rt = cArray.length -1;
        while (lt < rt ){
            char tmp = cArray[lt];
            cArray[lt] = cArray[rt];
            cArray[rt] = tmp;
            lt++;
            rt--;
        }
        return String.valueOf(cArray);
    }
}
