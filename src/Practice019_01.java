import java.io.*;
import java.util.Arrays;

public class Practice019_01 { /*2751*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());
        int [] a = new int [n];
        for(int i = 0; i<n; i++){
            a[i]  = Integer.parseInt(br.readLine());
        }
        //퀵 정렬
        quickSort(a,0,a.length-1); // arr, 맨 처음, arr의 끝 이  시작
        for (int arr:a) {
            bw.write(arr +"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void quickSort(int [] a, int start, int end){
        int pivot = partition(a,start,end);
        if(start < pivot -1){ // pivot이 맨 왼쪽에서 +1일때까지
            quickSort(a,start,pivot-1);
        }
        if(end > pivot){ // end가 pivot보다 클 때 까지
            quickSort(a,pivot,end);
        }
    }
    public static int partition(int []a, int start, int end){
        int pivot = a[(start + end) / 2]; // 배열에서 중간 인덱스 값 찾기
        while (start<=end){ // start가 작거나 같을때까지
            while (a[start] < pivot) start++;
            while (a[end] > pivot) end--;
            if(start <= end){
                swap(a,start,end);
                start++;
                end--;
            }
        }
        return start; // 분리된 배열의 첫번째
    }
    public static void swap(int []a, int i , int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] =  tmp;
    }
}
