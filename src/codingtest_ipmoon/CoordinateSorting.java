package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoordinateSorting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Point> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            Point p = new Point(x,y);
            arrayList.add(p);
        }
        Collections.sort(arrayList);
        for(Point o  : arrayList) System.out.println(o.x + " " + o.y);
    }
}
class Point implements Comparable<Point>{

    public int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y-o.y;
        return this.x - o.x;
    }
}
