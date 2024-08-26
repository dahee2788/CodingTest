package codingtest_ipmoon;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(char x : s1.toCharArray()){
            map1.put(x,map1.getOrDefault(x,0) + 1);
        }
        for(char x : s2.toCharArray()){
            map2.put(x,map2.getOrDefault(x,0) + 1);
        }
        System.out.println(map1.equals(map2)?"YES":"NO");
        System.out.println(solution(s1,s2));
    }
    /* 선생님 풀이 */
    static String solution(String s1, String s2){
        String answer = "YES";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x : s1.toCharArray()){
            map.put(x,map.getOrDefault(x,0) + 1);
        }
        for(char x : s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x,map.get(x) -1);
        }
        return answer;
    }
}
