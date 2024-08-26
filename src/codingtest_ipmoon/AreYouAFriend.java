package codingtest_ipmoon;

import java.util.*;

public class AreYouAFriend {
    static int[] unf;
    public static int find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb; // 만약 여태까지 친구 관계가 아니었다면 대입
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        unf = new int[n+1];
        for(int i = 1; i <=n; i++) unf[i] = i;
        for(int i = 1; i <=m; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            Union(a,b);
        }
        int a = s.nextInt();
        int b = s.nextInt();
        if(find(a) == find(b)) System.out.println("YES");
        else System.out.println("NO");

    }
}


