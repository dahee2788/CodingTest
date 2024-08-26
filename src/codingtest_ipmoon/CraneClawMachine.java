package codingtest_ipmoon;

import java.util.*;

public class CraneClawMachine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Stack<Integer>> stackList = new ArrayList<>();
        int[][]arr = new int[n][n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = s.nextInt();
            }
        }
        for(int k = 0; k<n; k++){
            Stack<Integer> arrStack = new Stack<>();
            for(int h = n-1; h >=0; h--){
                if(arr[h][k] != 0)arrStack.push(arr[h][k]);
            }
            stackList.add(arrStack);
        }
        int m = s.nextInt();
        int[]moves = new int[m];
        Stack<Integer>  stack = new Stack<>();
        for(int sm = 0; sm < m; sm++){
            int rt = s.nextInt();
            moves[sm] = rt;
           int p =  rt-1;
           if(!stackList.get(p).isEmpty()) {
               int o = stackList.get(p).pop();
               int sSize = stack.size();
               if (sSize == 0) stack.push(o);
               else {
                   if (stack.peek() == o) {
                       stack.pop();
                       cnt += 2;
                   } else stack.push(o);
               }
           }
        }
//        System.out.println(cnt);
        System.out.println(solution(arr,moves));
    }
    static int solution(int [][] board, int []moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves){
            for(int i = 0; i < board.length; i++){
                if(board[i][pos-1] != 0){
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if(!stack.isEmpty() && tmp == stack.peek()){
                        answer += 2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break;
                }

            }        }
        return answer;
    }
}
