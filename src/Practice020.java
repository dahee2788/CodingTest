import java.io.*;
import java.util.logging.Logger;

public class Practice020 {
    public static int[]a, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
         a = new int[n];
        tmp = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        merget_sort(0, a.length -1); // array의 시작과 끝 인덱스
        for (int arr:a) {
            bw.write(arr + "\n");
        }
        bw.flush();
        bw.close();

    }
    public static void merget_sort(int s, int e){
        if(s<e){
            int m = (s+e)/2;
            // 재귀함수
            merget_sort(s, m);
            merget_sort(m+1, e);
            // 병합 시작
            // 임시저장소에 정렬이 된만큼 배열 복사
            for(int i =s; i<=e; i++){
                tmp[i] = a[i];
            }
            int index1 = s; // 각 배열의 첫번째 원소
            int index2 = m +1; // 각 배열의 첫번째 원소
            int resIdx = s; //결과 배열의 인덱스(저장할 곳), 초기값은 start값과 같음

            while (index1 <= m && index2 <= e){ // 각 배열의 인덱스가 끝에 가기 전까지
                if(tmp[index1] > tmp[index2]){
                    a[resIdx] = tmp[index2];
                    index2++;
                    resIdx++; // 하나 추가해 줬기 때문
                }
                else{
                    a[resIdx] = tmp[index1];
                    index1++;
                    resIdx++;
                }
            }
            while (index1 <= m){ // 아직 인덱스가 남았다면 == 다 채워지지않았다면
                a[resIdx] = tmp[index1];
                index1++;
                resIdx++;
            }
            while (index2 <= e){ // 아직 인덱스가 남았다면 == 다 채워지지않았다면
                a[resIdx] = tmp[index2];
                index2++;
                resIdx++;
            }
        }
    }
}
