package codingtest_ipmoon;

import java.util.*;

public class ReverseSpecificCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char[] cArray = str.toCharArray();
        int lt = 0;
        int rt = cArray.length -1;
        while (lt < rt){
//            if(65 <= cArray[lt] && 122 >= cArray[lt]){
            if(Character.isAlphabetic(cArray[lt])){
//                if(65 <= cArray[rt] && 122 >= cArray[rt]){
                if(Character.isAlphabetic(cArray[rt])){
                    //swqp
                    char tmp = cArray[lt];
                    cArray[lt] = cArray[rt];
                    cArray[rt] = tmp;
                    lt++;
                    rt--;
                }else rt--;
            }else lt++;
        }
        System.out.println(String.valueOf(cArray));

    }
}
