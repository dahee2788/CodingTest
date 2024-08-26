import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Practice012_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        int [] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<a.length; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = n-1; i>=0; i--){
            while (!stack.isEmpty() && a[i] > stack.peekLast()){
                stack.pollLast(); // 작으면 빼버리기
            }
            answer[i] = stack.isEmpty()? -1 : stack.peekLast();
            stack.addLast(a[i]);

        }
        for(int i = 0 ; i < answer.length; i++){
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();

    }
}
