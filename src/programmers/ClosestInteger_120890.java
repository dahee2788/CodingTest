package programmers;

public class ClosestInteger_120890 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 10, 28},20));

    }
    public static int solution(int[] array, int n) {

        int [] arr = new int[array.length];

        for(int i = 0; i<array.length ; i++){
            arr[i] = Math.abs(n - array[i]);
        }

        int minDiff = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 0; i<array.length ; i++){

            if(minDiff > arr[i]){
                minDiff = arr[i];
                answer = array[i];
            }
            else if(minDiff == arr[i]){
                answer = Math.min(answer,array[i]);
            }
        }

        return answer;
    }
}
