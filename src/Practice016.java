import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        mData[]a = new mData[n];
        for(int i = 0; i < n; i++){
            a[i] = new mData(Integer.parseInt(br.readLine()), i); // 값과 idx
        }
        Arrays.sort(a); // 오름차순 정렬
        int max = 0; // 원래 인덱스와 오름차순 정렬 후의 값이 가장 큰 원소를 찾자
        for(int i = 0; i<n; i++){
            if(max < a[i].idx - i){ // 정렬전 - 지금 idx
                max = a[i].idx - i;
            }
        }
        System.out.println(max + 1); // 지문에서 1부터 시작


    }
}
class mData implements Comparable<mData>{
    int value; // 값
    int idx; // 받은 인덱스
    public mData(int value, int idx){
        this.value = value;
        this.idx = idx;
    }
    @Override
    public int compareTo(mData o) { // Value 기준 오름차순 정렬하기(구현 받기 위해서 필수)
        return this.value - o.value; // Arrays.sort에서 정렬의 기준이 됨
    }
}
