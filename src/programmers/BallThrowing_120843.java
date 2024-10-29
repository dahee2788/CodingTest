package programmers;

import java.util.ArrayList;
import java.util.List;

public class BallThrowing_120843 {
    public static void main(String[] args) {

        int [] numbers = {1,2,3,4};
        solution(numbers,2);
    }
    public static int solution(int[] numbers, int k) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        if((k * 2) > numbers.length){
            for(int i = 0; i<numbers.length*((k * 2)/numbers.length + 1); i++){

                list.add(numbers[i%numbers.length]);

            }

            answer = list.get(k + (k-2));
        }else {
            answer = numbers[k + (k-2)];
        }

        return answer;
    }
}
