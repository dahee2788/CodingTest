import java.util.Scanner;

public class Practice001 {
    public static void main(String[] args) {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 첫 n 입력받기
        int N = sc.nextInt();
        // 두번째 숫자 문자열로 입력받기
        String sNum = sc.next(); // string
        // string을 char 배열로 변경하기
        char[] cNum = sNum.toCharArray();
        // sum 변수 초기화
        int sum = 0;
        for(int i = 0; i<cNum.length; i++){
            //for문 돌면서 합산
            // - '0' : char를 정수형으로 변환
            sum += cNum[i] - '0';
//            sum += Integer.valueOf(String.valueOf(cNum[i]));
        }
        System.out.println(sum);
    }
}
