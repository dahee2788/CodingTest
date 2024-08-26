package codingtest_ipmoon;

import java.util.Scanner;

public class FindLongWord {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str = in.nextLine();
//        String[] sArray = str.split(" ");
//        int idx = 0;
//        for (int i = 1; i<sArray.length; i++){
//            if(sArray[idx].length() < sArray[i].length()) idx = i;
//        }
//        System.out.println(sArray[idx]);
        System.out.println(solution(str));

    }
    static String solution(String line){
        String answer ="";
        int pos;
        int m = Integer.MIN_VALUE;
        while ((pos = line.indexOf(" ")) != -1){
            String tmp = line.substring(0,pos);
            int len = tmp.length();
            if(len > m){
                m = len;
                answer = tmp;
            }
            line = line.substring(pos+1); // 잘라내기
        }
        if(line.length() > m) answer=line;
        return answer;
    }
}
