import java.io.*;
import java.util.StringTokenizer;

public class Practice021 {
    public static int[]a, tmp;
    public static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        merget_sort(0,a.length-1);
        System.out.println(result);

    }
    public static void merget_sort(int s,int e){
        if(s < e){
            // 가운데 숫자
            int m = (s+e)/2;
            merget_sort(s,m);
            merget_sort(m+1,e);
            // 병합 시작
            for(int i = s; i <=e; i++){
                tmp[i] = a[i];
            }
            int index1 = s;
            int index2 = m+1;
            int resIdx = s;
            while (index1 <= m && index2 <= e){
                if(tmp[index1] > tmp[index2]){
                    a[resIdx] = tmp[index2];
                    result += (index2 - resIdx); // 계산한 수 만큼 이동의 여지가 있는 수의 개수가 나옴 
//                    result += (m+1 - index1); // 가운데 숫자에서 첫번째 배열 인덱스 만큼 빼기
                    index2++;
                }
                else{
                    a[resIdx] = tmp[index1];
                    index1++;
                }
                resIdx++;
            }
            // 정렬 다 끝났는데도 남은 배열이 있다
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
