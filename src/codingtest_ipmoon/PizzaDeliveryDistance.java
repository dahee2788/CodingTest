package codingtest_ipmoon;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaDeliveryDistance {
    static int n,m,answer = Integer.MAX_VALUE;
    static int[][]city;
    static int[][]pizzaShop;
    static ArrayList<int []> pizza  = new ArrayList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        city = new int[n][n];
        pizzaShop = new int[m][2];
        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                city[i][j] = s.nextInt();
                if(city[i][j] == 2) pizza.add(new int[]{i,j});
            }
        }
        PizzaDeliveryDistance t = new PizzaDeliveryDistance();
        t.DFS(0,0);
        System.out.println(answer);
    }
    public void DFS(int l, int s){
        if(l == m){
//            for (int i=0; i<pizzaShop.length; i++){
//                System.out.print(pizzaShop[i][0] + " " +pizzaShop[i][1] +" / ");
//            }
//            System.out.println();
            answer = Math.min(answer,calculDistance(pizzaShop));
        }else {
            for(int i  = s; i < pizza.size(); i++ ){
                pizzaShop[l] = pizza.get(i);
                DFS(l+1,i+1);
            }
        }
    }

    public int calculDistance(int [][] suv){
        int res = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j < n; j++){
                if(city[i][j] == 1){
                    int ids = Integer.MAX_VALUE;
                    for(int x = 0; x <suv.length; x++){
                        ids = Math.min(ids,  Math.abs(i-suv[x][0]) + Math.abs(j-suv[x][1]));
                    }
                    res += ids;
                }
            }
        }
        return  res;
    }
}
