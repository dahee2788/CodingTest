import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int a[] = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(a,0,a.length-1,k-1);
        System.out.println(a[k-1]);
    }
    public static void quickSort(int[]a, int s, int e, int k){
        if(s < e){
            int pivot = partition(a,s,e);
            if(pivot == k) return;
            else if(k < pivot) quickSort(a,s,pivot-1,k); // k 피벗보다 작으면 왼쪽 그룹만 정렬
            else quickSort(a,pivot+1,e,k); // k가 피벗보다 크면 오른쪽 그룹만 정렬
        }
    }
    public static int partition(int[]a, int s, int e){
        if(s+1==e) {
            if(a[s]>a[e])swap(a,s,e);
            return e;
        }
        int m = (s + e) / 2;
        swap(a, s, m); // 중앙값을 1번째 요소로 이동하기
        int pivot = a[s];
        int i = s+1, j = e;

        while (i <= j) {
            while (pivot < a[j] && j > 0 ){   //피벗보다 작은 수가 나올때까지 j--
                j--;
            }
            while (pivot > a[i]  && i <a.length-1){  //피벗보다 큰 수가 나올 떄까지 i++
                i ++;
            }
            if (i <= j) {
                swap (a, i++, j--);  // 찾은 i와 j를 교환하기
            }
        }
        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        a[s] = a[j];
        a[j] = pivot;
        return j;
    }
    public static void swap(int[]a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
