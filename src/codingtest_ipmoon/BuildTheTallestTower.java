package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BuildTheTallestTower {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Block> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            Block block = new Block(a,b,c);
            list.add(block);
        }
        Collections.sort(list);
        BuildTheTallestTower t = new BuildTheTallestTower();
        System.out.println(t.Dy(list));

    }
    int Dy(List<Block> list){
        int answer = 0;
        int [] dy = new int[list.size()]; // 해당 돌의 차례가 왔을땨 돌이 쌓을 수 있는 최대 길이
        // 1번째꺼는 무조건 놓기
        dy[0] = list.get(0).height;
        for(int i = 0; i< list.size(); i++){
            int max = 0; //
            for(int j = i-1; j >=0; j--){
                if(list.get(j).width > list.get(i).width && list.get(j).weight > list.get(i).weight && max < dy[j]) max = dy[j];
            }
            dy[i] = max+list.get(i).height;
            answer = Math.max(answer,dy[i]);
        }
        return answer;
    }



}
class Block implements Comparable<Block>{
    int width;
    int height;
    int weight;

    public Block(int a, int b, int  c){
        this.width = a;
        this.height = b;
        this.weight = c;
    }

    @Override
    public int compareTo(Block o) {
        return o.width - this.width;
    }
}
