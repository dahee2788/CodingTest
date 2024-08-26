package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSumProblem {
    static int n, total = 0;
    static int [] arr;
    static List<SubClass> list = new ArrayList<>();

    static String answer = "NO";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        arr = new int[n];
        for(int i = 0; i<n; i++){
            int a = s.nextInt();
            arr[i] = a;
            SubClass c = new SubClass(a);
            list.add(c);
            total += a;
        }
        SubsetSumProblem t = new SubsetSumProblem();
        System.out.println(t.DFS(0));
        System.out.println(t.DFS(0,arr[0],arr));
    }
    public String DFS(int v){
        if(v == n){
         int leftSum =    list.stream().filter(l->l.chk == true).mapToInt(l->l.number).sum();
            //            left.stream().mapToInt(Integer::intValue).sum();
         int rightSum =    list.stream().filter(l->l.chk == false).mapToInt(l->l.number).sum();
         if(leftSum == rightSum){
             answer = "YES";
             return answer;
         }
        }else{
            SubClass c = list.get(v);
            c.setChk(true);
            list.set(v,c);
            DFS(v+1);
            c.setChk(false);
            list.set(v,c);
            DFS(v+1);
        }
        return answer;
    }
    // 선생님풀이
    public String DFS(int l, int sum, int[] arr){
        if(l == n){
            if(total-sum == sum){
                answer = "YES";
                return answer;
            }
        }
        else{
            DFS(l+1,sum + arr[l], arr);
            DFS(l+1,sum, arr);

        }
        return answer;
    }
}

class SubClass{
    int number;
    boolean chk;

    public SubClass(int number){
        this.number = number;
        this.chk = false;
    }
    void setChk(boolean v){
        this.chk = v;
    }
}
