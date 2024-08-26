package programmers;

public class SumOfConsecutiveSubsequences_178870 {
    public static void main(String[] args) {
        int [] arr = new int[]{2, 2, 2, 2, 2};
        int k = 6;
        int [] arr2  = solution(arr,k);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);

    }
    public static int[] solution(int[] sequence, int k) {
        int sum = 0;
        int lt = 0;
        int[] answer = new int[2];
        int tempSize = 0;
        for(int rt = 0; rt < sequence.length; rt++){
           sum += sequence[rt];
           if(sum == k){
               if(tempSize == 0){
                   tempSize = (rt-lt) + 1;
                   answer = new int[]{lt,rt};
               }
               else {
                   if(tempSize > (rt-lt) + 1) {
                       tempSize = (rt-lt) + 1;
                       answer = new int[]{lt,rt};
                   }
               }
           }
            while (sum >= k){
                sum -= sequence[lt++];
                if(sum == k){
                    if(tempSize == 0){
                        tempSize = (rt-lt) + 1;
                        answer = new int[]{lt,rt};
                    }
                    else {
                        if(tempSize > (rt-lt) + 1) {
                            tempSize = (rt-lt) + 1;
                            answer = new int[]{lt,rt};
                        }
                    }
                }
            }
        }

        return answer;
    }
}
