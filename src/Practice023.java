import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice023 {
    static ArrayList<Integer>[] a;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i<n+1; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i =0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 양방향 엣지이므로 양쪽에 엣지를 더하기
            a[s].add(e);
            a[e].add(s);
        }
        int cnt = 0;
        for(int i = 1; i < n+1; i++){
            if(!visited[i]){ // false 이면 == 한번도 방문안했으면
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);

    }
    static void DFS(int v){
        if(visited[v]) return; // 이미 방문했으면 return;
        visited[v] = true;
        for(int i : a[v]){
            // array v 에 있는 모든 이웃값 모두 깊이 탐색
            if(visited[i] == false) DFS(i);
        }
    }
}
