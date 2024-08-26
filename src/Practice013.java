import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Practice013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> que = new ArrayDeque<>();

        // n까지의 자연수 넣기
        for (int i=1; i<=n; i++) que.addLast(i);

        while (que.size() > 1){
            que.pollFirst();
            que.addLast(que.pollFirst());
        }
        System.out.println(que.pollFirst());
    }
}
