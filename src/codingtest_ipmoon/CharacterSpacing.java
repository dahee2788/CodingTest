package codingtest_ipmoon;

import java.util.Scanner;

public class CharacterSpacing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char t = str.split(" ")[1].charAt(0);
        str = str.split(" ")[0];

        int[] iArray = new int[str.length()];
        int cnt = 0;
        /* 정방향 */
        for(int i =0; i < iArray.length; i++){
            if(str.charAt(i) == t) cnt = 0;
            else  cnt++;
            iArray[i] = cnt;

        }
        /* 역방향 */
        cnt = 0;
        for(int i = iArray.length -1; i >= 0; i--){
            if(str.charAt(i) == t) cnt = 0;
            else  cnt++;
            if(iArray[i] > cnt && i != 0 && i != iArray.length -1)iArray[i] = cnt;
            if(iArray[i] < cnt && (i == 0 || i == iArray.length -1))iArray[i] = cnt;

        }
        iArray = solution(str,t);
        for(int i =0; i < iArray.length; i++){
            System.out.print(iArray[i] + " ");
        }


    }

    static int[] solution(String str, char t){
        int[]iArray = new int[str.length()];
        int cnt = str.length();
        /* 정방향 */
        for(int i =0; i < iArray.length; i++){
            if(str.charAt(i) == t) cnt = 0;
            else  cnt++;
            iArray[i] = cnt;

        }
        /* 역방향 */
        cnt = str.length();
        for(int i = iArray.length -1; i >= 0; i--){
            if(str.charAt(i) == t) cnt = 0;
            else  cnt++;
            if(iArray[i] > cnt )iArray[i] = cnt;
        }
        return  iArray;
    }
}
