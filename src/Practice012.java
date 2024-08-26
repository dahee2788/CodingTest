import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        int [] ans = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // index 0 넣고 시작.
        for(int i =1; i<a.length; i++){
         while (!stack.empty() && a[stack.peek()] < a[i]){
             ans[stack.pop()] = a[i];
         }
         stack.push(i); // 신규데이터 j++와 같음
        }
        while (!stack.empty()){
            ans[stack.pop()] = -1;
        }
        for(int i = 0; i<ans.length; i++){
            sb.append(ans[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
