package codingtest_ipmoon;

import java.util.*;

public class CoinExchange {
    static int n, m, answer = Integer.MAX_VALUE;
    static int [] kind;
    static int [] chk = new int[500];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        kind = new int[n];
        for(int i =0; i<n; i++) kind[i] = s.nextInt();
//        Arrays.sort(kind, Collections.reverseOrder());
        m = s.nextInt();
        CoinExchange t = new CoinExchange();
//        t.BFS(m);
        t.DFS(0,0);
        System.out.println(answer);

    }
    public void BFS(int change){
        int l = 0; // 레벨
        chk[0] = 1;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sum);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size; i++){
                int q = queue.poll();
                if(q == change){
                    System.out.println(l);
                    return;
                }
                for(int j  = 0; j < n; j++){
                    int tmp = q + kind[j];
                    if(chk[tmp] == 0){
                        queue.offer(tmp);
                        chk[tmp] = 1;
                    }
                }
            }
            l++;
        }
    }
    public void DFS(int l, int sum){
        if(sum > m) return;
        if(l >= answer) return; // answer보다 더 깊은레벨로 들어갈 필요 없음, 체크하지 않는다면 timeout
        if(sum == m){
            answer = Math.min(answer,l);
        }else {
            for(int i  = n-1; i>=0; i--){ //  오름차순으로 진행하면 time limit 걸림
                DFS(l+1, sum + kind[i]);
            }
        }
    }
}
