package codingtest_ipmoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n  = Integer.parseInt(s.nextLine());
        String vote = s.nextLine();
        String []votes = vote.split("");
        HashMap<String,Integer> result = new HashMap<>();
        for(int i = 0; i < n; i++ ){
            if(result.containsKey(votes[i])){
                int v = result.get(votes[i]);
                result.put(votes[i], v+1);
            } else  result.put(votes[i],1);

        }

        String resp = "";
        int answer = 0;
        for (Map.Entry<String,Integer> e: result.entrySet()) {
            if(e.getValue() > answer) {
                answer = e.getValue();
                resp = e.getKey();
            }
        }
        System.out.println(resp);
        System.out.println(solution(n, vote));
    }
    /* 선새님 풀이 */
    static char solution(int n, String vote){
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : vote.toCharArray()){
            map.put(x,map.getOrDefault(x,0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }
}
