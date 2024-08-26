package codingtest_ipmoon;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String arrayLength = s.nextLine();
        String str = s.nextLine();
        int cLen = 7;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<Integer.valueOf(arrayLength); i++){
            String oneWord = str.substring(cLen*i,cLen*(i+1)).replace("#","1").replace("*","0");
//            oneWord = oneWord.replace("#","1").replace("*","0");
            String[]sArray = oneWord.split("");
            int oneNum = 0;
//            for(int j = sArray.length-1; j >=0; j--){
//                if("1".equals(sArray[(sArray.length-1)-j])) {
//                    if(j == 0) oneNum += 1;
//                    else oneNum += Math.pow(2,j);
//                }
//            }
            oneNum = solution(oneWord);
            sb.append((char)oneNum);
        }
        System.out.println(sb.toString());


    }
    static int solution(String twoNum){
        return Integer.parseInt(twoNum,2);
    }
}
