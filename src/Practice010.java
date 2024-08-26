import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Practice010 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter 사용
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 덱 생성
        Deque<Node> mydeque = new LinkedList<>();
        st = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= n; i++){
            int now = Integer.parseInt(st.nextToken());
            // 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해서 시간 복잡도를 줄임-> 최소값을 구하는 것이기 때문에
            while (!mydeque.isEmpty() && mydeque.getLast().value > now){
                // 비어있지 않고 직전 노드값이 현재꺼보다 크다면 삭제
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now,i)); // Node 추가
            if(mydeque.getFirst().index <= i -l){ // 범위를 벗어나는 노드는 삭제
                mydeque.removeFirst();
            }
            bufferedWriter.write(mydeque.getFirst().value+" ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
