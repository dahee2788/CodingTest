package backjoon;

import java.io.*;
import java.util.ArrayDeque;

public class No9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[]a = new String[n];

        for(int i = 0; i<n; i++){
            String[]st = br.readLine().split("");
            ArrayDeque<String> stack = new ArrayDeque<>();
            for(int j = 0; j < st.length; j++){
                // 비었거나 ( 이면 push
                if(st[j].equalsIgnoreCase("(") || stack.isEmpty()) stack.addLast(st[j]);
                else{
                    // top이 ( 이고 지금 원소가 )라면 top 제거
                    if( !st[j].equalsIgnoreCase(stack.peekLast())){
                      stack.pollLast();
                    }
                }
            }
            a[i] = stack.isEmpty()?"YES":"NO";
        }
        for(int i =0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
}
