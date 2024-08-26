package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No1759 {
    static int l;
    static int c;
    static String [] answer;
    static String [] cArr;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        l  = s.nextInt();
        c = s.nextInt();
        cArr  = new String[c];
        answer  = new String[l];
        for(int i = 0; i< c; i++) cArr[i] = s.next();
        Arrays.sort(cArr);
        dfs(0,0);

    }
    static void dfs(int level,int s){
        if(l == level ){
            if(chkAnswer(answer)){
                for(String cc : answer) System.out.print(cc +"");
                System.out.println();
            }else return;
        }else {
            for(int i  = s; i < c;i++){
                    answer[level] = cArr[i];
                    dfs(level+1,i+1);
            }
        }
    }
    static boolean chkAnswer(String[] arr){
        ArrayList<String> list  = new ArrayList<>();
        list.add("a");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("u");
        int m = 0, n = 0;
        for(String a : arr){
            if(list.contains(a)) m++;
            else n++;
        }
        if(m < 1 || n < 2) return false;
        else return true;
    }
}
