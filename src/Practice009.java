import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice009 {
   static int[]myArr;
   static int[]checkArr;
   static int checkSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bufferedReader.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[]a = bufferedReader.readLine().toCharArray();

        myArr = new int[4];
        checkArr = new int[4];
        checkSecret = 0;
        int result = 0;

        st = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < checkArr.length; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) checkSecret++; // 0이면 체크 할게 없음.
        }

        // 초기 계산
        for(int i = 0; i < p; i++){
            Add(a[i]);
        }
        if(checkSecret == 4) result++;

        //슬라이딩 윈도우
        for(int i = p; i<s; i++){
            // 한개 늘어나면 뒤에꺼 한개 삭제 -> 슬라이딩 윈도우
            int j = i - p; // 삭제할 인덱스 현재 - 슬라이딩 넓이
            Add(a[i]);
            Remove(a[j]);
            if(checkSecret == 4) result++;
        }
        System.out.println(result);


    }

    static void Add(char c){
        switch (c){
            case 'A'  :
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C'  :
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G'  :
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T'  :
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

   static void Remove(char c){
       switch (c){
           case 'A'  :
               if(myArr[0] == checkArr[0]) checkSecret--; // 지난 원소에서 갯수를 충족 하는게 있다면 빼버리기
               myArr[0]--;
               break;
           case 'C'  :
               if(myArr[1] == checkArr[1]) checkSecret--;
               myArr[1]--;
               break;
           case 'G'  :
               if(myArr[2] == checkArr[2]) checkSecret--;
               myArr[2]--;
               break;
           case 'T'  :
               if(myArr[3] == checkArr[3]) checkSecret--;
               myArr[3]--;
               break;
       }
   }
}
