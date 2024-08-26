package codingtest_ipmoon;

import java.util.*;
import java.util.stream.Stream;

public class EmergencyRoom {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int  n  = s.nextInt();
        int m = s.nextInt();
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Person> q = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            q.offer(new Person(i,s.nextInt()));
        }
//        while (map.size() < n){
//            Person x = q.poll();
//            Stream<Person> stream =   q.stream().filter(o->o.priority > x.priority);
//            if(stream.count() == 0) {
//                cnt++;
//                map.put(x.id,cnt);
//            }
//            else q.offer(x);
//        }
//        System.out.println(map.get(m));
        System.out.println(solution(n,m,q));

    }
    static int solution(int n, int m , Queue<Person> q){
            int answer = 0;
            while (!q.isEmpty()){
                Person tmp = q.poll();
                for (Person x : q){
                    if(x.priority > tmp.priority){
                        q.offer(tmp);
                        tmp = null;
                        break;
                    }
                }
                if(tmp != null){
                    answer++;
                    if(tmp.id == m) return answer;
                }
            }
            return answer;
        }

}
class Person{

    int id;
    int priority;
    public Person(int id , int priority){
        this.id = id;
        this.priority = priority;
    }
}
