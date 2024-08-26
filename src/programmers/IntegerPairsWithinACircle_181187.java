package programmers;

public class IntegerPairsWithinACircle_181187 {
    public static void main(String[] args) {
        System.out.println(solution(2,3));
    }
    public static long solution(int r1, int r2) {
        long answer = 0;
        double r1Pow = Math.pow(r1,2); // 작은 원 반지름 제곱
        double r2Pow = Math.pow(r2,2); // 큰 원 반지름 제곱

        int onlineCount = (r2 - r1 + 1) * 4; // 4분면에 대한 선 위에 있는 좌표 구하기
        for(int i = 0; i<= r2; i++){ // 큰 원 만큼 for문
            double xPow = Math.pow(i,2);
            if(i > r1) r1Pow = 0;
            double y1 =0; // i가 r1 넘어가면 0으로 유지
            if(r1Pow != 0){
                y1 = Math.sqrt(r1Pow - xPow); //작은원의 y좌표 구하기
                if(y1 > Math.floor(y1)){ // 반올림 대상이면
                    y1 = Math.ceil(y1); // 올림
                }
            }
            double y2 = Math.sqrt(r2Pow - xPow); //큰원의 y좌표 구하기
            if(y2 > Math.floor(y2)){ // 반올림 대상이면
                y2 = Math.floor(y2); // 올림
            }
            answer += (int)y2 - (int)y1 + 1; // 좌표 정점의 갯수구하기 y-x +1
        }

        return answer*4 - onlineCount; //중복 계산된 점 빼주기 // 1사분면 계산 결과 값을 *4할때 x,y축 좌표들이 중복된다.
    }
}
