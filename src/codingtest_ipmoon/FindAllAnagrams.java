package codingtest_ipmoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindAllAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int l = t.length();
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();
        int cnt = 0;
        int lt = 0;
        // t -> map에 넣기
        for(Character x : t.toCharArray()) tmap.put(x,tmap.getOrDefault(x,0) + 1);

        // t length 까지
        for(int i = 0; i < l-1; i++) map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);

        for(int rt = l-1; rt < s.length(); rt++){
            map.put(s.charAt(rt),map.getOrDefault(s.charAt(rt),0) + 1);
            if(map.equals(tmap)) cnt++;
            // lt 제거
            if(map.get(s.charAt(lt)) == 1) map.remove(s.charAt(lt));
            else map.put(s.charAt(lt), map.get(s.charAt(lt)) -1);
            lt++;
        }
        System.out.println(cnt);





    }
}
