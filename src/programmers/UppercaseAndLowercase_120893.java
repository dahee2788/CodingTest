package programmers;

public class UppercaseAndLowercase_120893 {
    public static void main(String[] args) {
        System.out.println(solution("cccCCC"));
    }
    public static String solution(String my_string) {
        String answer = "";
        for(char c : my_string.toCharArray()) {
           if( Character.isUpperCase(c)){
               answer += Character.toLowerCase(c);
            }
           else{
               answer += Character.toUpperCase(c);
           }
        }
        return answer;
    }
}
