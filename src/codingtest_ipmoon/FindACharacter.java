package codingtest_ipmoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FindACharacter {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String line = in.nextLine();
        String f = in.nextLine();
        String[]sArray = line.split("");
        int cnt = 0;
        Stream<String> flist = Arrays.stream(sArray).toList().stream().filter(o-> o.equalsIgnoreCase(f));
//        for (String fc : sArray){
//            if(fc.equalsIgnoreCase(f)) cnt++;
//        }
//        System.out.println(flist.count());
        System.out.println(solution(line,f));
        return;
    }

    public static int solution(String line, String f){
        line = line.toUpperCase();
        f = f.toUpperCase();
        int c = 0;
        for (int i = 0; i < line.length(); i++){
            if(line.charAt(i) == f.charAt(0)) c++;
        }
        return c;
    }
}
