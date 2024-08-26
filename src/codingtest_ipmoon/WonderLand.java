package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WonderLand {
    static int [] dis;
    static int sum = 0;
    static int Find(int v){
        if(v == dis[v]) return v;
        else return dis[v] = Find(dis[v]);
    }
    static void Union(int a , int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) dis[fa] = fb;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();

        dis = new int[v+1];
        for(int i = 0; i<=v; i++) dis[i] = i;
        List<City> list = new ArrayList<>();
        for(int i = 0; i<e; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            City city = new City(a,b,c);
            list.add(city);
        }
        Collections.sort(list);
        list.forEach(o->{
            if(Find(o.v1) != Find(o.v2)){
                Union(o.v1,o.v2);
                sum+=o.cost;
            }
        });
        System.out.println(sum);


    }

}
class City implements Comparable<City>{
    int v1;
    int v2;
    int cost;
    public City(int v1, int v2, int cost){
        this.v1  = v1;
        this.v2  = v2;
        this.cost  = cost;
    }

    @Override
    public int compareTo(City o) {
        return this.cost - o.cost;
    }
}