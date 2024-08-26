import java.io.*;
import java.util.Stack;

public class Practice011 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bw = new StringBuffer();// bufferwriter 는 버퍼가 가득 차면 자도으로 배출, 사이즈를 늘려서 하면 메모리 초과 // 스트링 빌더나 버퍼를 쓸 것

        int n = Integer.parseInt(br.readLine());
        int []a = new int[n];
        for(int i = 0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        // 스택
        Stack<Integer> stack = new Stack<>();
        int num  = 1; // 오름차순 수
        boolean termYn = false;
        for(int i = 0; i < n; i++){
            int su = a[i]; //출력해야할 수
            if(su >= num){
                // 출력해야하는 수 까지
                while (su >= num){
                    stack.push(num++);
                    bw.append("+\n");
                }
                // 삭제해서 출력
                stack.pop();
                bw.append("-\n");
            }
            else {
                int p = stack.peek(); // 출력해야할 수보다 push할 수가 더 클때 // 맨 위의 수 확인
                if(p > su){ // stack 맨 위의 수보다 출력해야할 수가 더 작을 때
                    System.out.println("NO");
                    termYn = true;
                    break;
                }
                else {
                    // 맨 위의 수와 출력해야할 수가 같다면 pop
                    stack.pop();
                    bw.append("-\n");
                }

            }
        }
        if(!termYn){
           System.out.println(bw.toString());
        }
    }
}
