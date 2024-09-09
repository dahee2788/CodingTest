package programmers;

import java.util.*;

public class FeatureDevelopment_42586 {
    public static void main(String[] args) {
//    int [] progresses = {93, 30, 55};
    int [] progresses = {95, 90, 99, 99, 80, 99};
//    int [] speeds = {1, 30, 5};
    int [] speeds = {1, 1, 1, 1, 1, 1};

       int [] answer =  solution(progresses,speeds);
       for(int a : answer) {
           System.out.println(a);
       }

    }
    public static int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> progressQueue  = new LinkedList<>();
        Queue<Integer> speedQueue  = new LinkedList<>();

        for(int progress : progresses) {
            progressQueue.offer(progress);
        }for(int speed : speeds) {
            speedQueue.offer(speed);
        }

        while(!progressQueue.isEmpty()) {
            int progress = progressQueue.peek();
            int speed = speedQueue.peek();
            int remainder = (100 - progress) % speed;
            int day = (100 - progress) / speed ;
            if(remainder > 0) day++;

            // 큐의 크기를 저장
            int size = progressQueue.size();

            // 큐의 요소를 반복하며 처리하고 다시 넣기
            for (int i = 0; i < size; i++) {
                int speedElement = speedQueue.poll();
                Integer element = progressQueue.poll() + (day * speedElement); // 큐에서 요소 제거
                progressQueue.offer(element); // 요소를 다시 큐에 추가
                speedQueue.offer(speedElement); // 요소를 다시 큐에 추가
            }
            int count = 0;
            while(!progressQueue.isEmpty() && progressQueue.peek() >= 100 ) {
                if(progressQueue.peek() >= 100) {
                    progressQueue.poll();
                    speedQueue.poll();
                    count++;
                }
            }
            answerList.add(count);
        }
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
