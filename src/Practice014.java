import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Practice014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            // comparator 사용해서 정렬순서 custom
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second) return o1 > o2 ? 1:-1; // o1더 크면 양수-> 그대로,  o2가 더 크면 음수->순서바꾸기
            else return first - second; // first 가 더 크면 양수 -> 그대로, second가 더 크면 음수 -> 순서 바꾸기
        }));

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if( num == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            }
            else queue.add(num);


        }
    }
}
