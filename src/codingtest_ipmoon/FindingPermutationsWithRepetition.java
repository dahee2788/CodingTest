package codingtest_ipmoon;

import java.util.*;

public class FindingPermutationsWithRepetition {
    static int n,m;
    static int [] numArr;
    static Queue<ArrayList<Integer>> queue = new LinkedList<>();
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        numArr = new int[n];
        for(int i = 1; i<=n; i++) numArr[i-1] = i;
        FindingPermutationsWithRepetition t = new FindingPermutationsWithRepetition();
//        t.DFS(0, new ArrayList<Integer>());
//        for(List<Integer> cl : list){
//                for (int a:cl) System.out.print(a + "");
//                System.out.println();
//            }
//        t.BFS();
        t.DFS(0,new int[m]);
    }
    public void DFS(int l, ArrayList<Integer> arr){
        if( l >= m) return;
        else {
            if(list.contains(arr)) list.remove(arr);
            for(int n : numArr){
                ArrayList<Integer> na = (ArrayList<Integer>) arr.clone();
                na.add(n);
                if(!list.contains(na)){
                    list.add(na);
                    DFS(l+1, na);
                }
            }
        }
    }
    /* 선생님 풀이 */
    public void DFS(int l, int [] arr){
        if( l > m) return;
        if(l == m ){
            for(int a : arr) System.out.print(a+"");
            System.out.println();
        }
        else {
            for(int n : numArr){
                arr[l] = n;
                DFS(l+1, arr);
            }
        }
    }
    public void BFS(){
        int l = 0;
        ArrayList<Integer> root = new ArrayList<>();
        queue.offer(root);
        while (l<m){
            int size = queue.size();
            for(int i =0; i<size; i++){
                ArrayList<Integer> cq = queue.poll();
                for (int n: numArr) {
                    ArrayList<Integer> na = (ArrayList<Integer>) cq.clone();
                    na.add(n);
                    if(!queue.contains(na))queue.offer(na);
                }
            }
            l++;
        }
        while (!queue.isEmpty()){
            ArrayList<Integer> q =  queue.poll();
            for (int a: q) System.out.print(a +"");

            System.out.println();
        }
    }
}
