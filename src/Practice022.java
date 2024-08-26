import java.io.*;

public class Practice022 {
    public static int[]a;
    long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine()); // 숫자 값 넣기
        }
        br.close();
        // 기수 정렬
        Radix_Sort(a,5); // 10,000이하의 수 => 5자리
        for(int i = 0; i < n; i++){
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static void Radix_Sort(int[] a, int max_size){
        int[] output = new int[a.length];
        int jarisu = 1; // 처음에는 일의 자리부터 시작
        int count = 0;
        while(count < max_size){
            int[] bucket = new int[10]; // 10진수 0 1부터 10까지
            for(int i = 0; i<a.length; i++){
                bucket[(a[i] / jarisu)%10]++; // 자리수로 나누고 10으로 나눈 나머지는 자리수를 나타냄 ex) 11 -> 1
            }
            for(int i =1; i < 10; i++){
                bucket[i] += bucket[i-1]; // 합배열 인덱스0을 그냥 냅두고 1부터 이전 합들을 본인 인덱스의 값과 더함
            }
            for(int i = a.length -1; i >= 0; i--){ // 현재자리수를 기준으로 정렬하기 -1은 인덱스는 0부터 시작인데 숫자는 일부터시작이라서
                output[bucket[(a[i]/jarisu % 10)] - 1] = a[i]; //  이해가 잘 안됨 다음 자리수 이동을 위해 아웃풋에 저장..?
                bucket[(a[i] / jarisu) % 10]--; // 한개씩빼기 -1은 왜 : 같은 자리를 찾아와도 중복된 인덱스에 값을 넣지 않도록 --(맨 뒤에서 부터 시작할테니 그 앞으로는 계속 인덱스가 적음)
            }
            for(int i = 0; i< a.length; i++){
                // 다음 자리수를 이동하기 위해 현자 자릿수 기준 정렬 데이터 저장하기
                a[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;

        }
    }
}
