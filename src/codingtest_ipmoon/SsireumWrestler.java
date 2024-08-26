package codingtest_ipmoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SsireumWrestler {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Applicant> list = new ArrayList<>();
        int answer = 0 ;
        for(int i  = 0; i<n; i++){
            int h = s.nextInt();
            int w = s.nextInt();
            Applicant a = new Applicant(h,w);
            list.add(a);
        }

//        for(int i = 0 ; i<n; i++){
//            Applicant a = list.get(i);
//            boolean flag = true;
//            for(int j = 0; j < n; j++){
//                if(i != j){
//                    Applicant b = list.get(j);
//                    if(a.height < b.height && a.weight < b.weight){
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//            if(flag) answer++;
//        }
//        System.out.println(answer);
        SsireumWrestler t = new SsireumWrestler();
        t.solution(list);
    }

    public void solution(List<Applicant> applicants){
        int res= 0;
        int maxWeight= 0;
        Collections.sort(applicants);
        for(int i = 0; i<applicants.size(); i++){
            if(maxWeight < applicants.get(i).weight){
                maxWeight = applicants.get(i).weight;
                res++;
            }
        }
        System.out.println(res);
    }
}

class Applicant implements Comparable<Applicant>{
    int height;
    int weight;
    public Applicant(int height,int weight){
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Applicant o) {
        return o.height - this.height;
    }
}
