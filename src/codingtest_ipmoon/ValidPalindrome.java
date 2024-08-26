package codingtest_ipmoon;

import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        str = str.replaceAll("[^a-zA-Z]","");
        String isTrue = "NO";
        String sb = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(sb)) isTrue = "YES";
        System.out.println(isTrue);
    }
}
