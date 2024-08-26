package programmers;

import java.util.ArrayDeque;

public class 주식가격 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] a = {1, 2, 3, 2, 3};
        int [] result = s.solution(a);
        if(result.length > 0){
            for(int i = 0; i<result.length; i++){
                System.out.println(result[i]);
            }
        }
    }

     static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            ArrayDeque<Number> stack = new ArrayDeque<>();
            for(int i = prices.length -1; i>=0; i--){
                while (!stack.isEmpty() && stack.peekLast().val >= prices[i]){
                    stack.pollLast(); //이미 들어가 있는 수가 해당 값보다 크다면 빼기 ==
                }
                answer[i] = stack.isEmpty() ? prices.length -1 -i : stack.peekLast().idx - i;
                stack.addLast(new Number(i,prices[i]));
            }
            return answer;
        }
    }
    private static class Number{
        int idx;
        int val;

        public Number(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }

}
