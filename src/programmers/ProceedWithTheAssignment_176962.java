package programmers;

import java.util.*;

public class ProceedWithTheAssignment_176962 {
    public static void main(String[] args) {
//        String[][] question  =  {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
//        String[][] question  =  {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[][] question = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
//        String[][] question  =  {{"a","09:00","30"},{"b","09:10","20"},{"c","09:15","20"},{"d","09:55","10"},{"e","10:50","5"}};
        String[] arr = solution(question);
        for (String str : arr) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[][] plans) {

        PriorityQueue<Assignment> queue = new PriorityQueue<>();
        List<String> answerList = new ArrayList<>();
        Stack<Assignment> stack = new Stack<>();

        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = converToMinuets(plans[i][1]);
            int playtime = Integer.valueOf(plans[i][2]);

            queue.add(new Assignment(name, start, playtime));
        }
        // queue가 빌때까지
        while (!queue.isEmpty()) {

            Assignment currentAssignment = queue.poll();

            // 현재 시간
            int currentTime = currentAssignment.start;

            // 새로 진행해야하는 과제
            if (!queue.isEmpty()) {

                Assignment nextAssignment = queue.peek();

                // 지금 과제를 끝내고 다음 과제 시작 시간까지 시간이 남는 경우
                if (currentTime + currentAssignment.playtime <= nextAssignment.start) {
                    answerList.add(currentAssignment.name);
                    currentTime += currentAssignment.playtime;

                    // 잠시 멈춘 과제가 있는 경우, 남는 시간 동안 멈췄던 과제 해결
                    while (!stack.isEmpty()) {
                        Assignment remainAssignment = stack.pop();

                        // 다음 새로운 과제 시작 전까지 다 멈춘 과제를 다 끝낼 수 있는 경우.
                        if (currentTime + remainAssignment.playtime <= nextAssignment.start) {
                            answerList.add(remainAssignment.name);
                            currentTime += remainAssignment.playtime;
                        } else {
                            // 다음 새로운 과제 시작전까지 못 끝내는 경우, 남은 과제를 또 넘겨야함
                            int timeGap = nextAssignment.start - currentTime;
                            stack.push(new Assignment(remainAssignment.name, remainAssignment.start + timeGap, remainAssignment.playtime - timeGap));
                            break;
                        }
                    }

                } else {
                    int timeGap = nextAssignment.start - currentTime;
                    stack.push(new Assignment(currentAssignment.name, currentAssignment.start + timeGap, currentAssignment.playtime - timeGap));
                }
            }
            // 중단했던 과제
            else {
                answerList.add(currentAssignment.name);
                // 남아있는 과제 있는지 확인
                    while (!stack.isEmpty()) {
                        Assignment remainAssignment = stack.pop();
                        answerList.add(remainAssignment.name);
                    }
            }

        }
        return answerList.toArray(new String[answerList.size()]);

    }

    public static int converToMinuets(String start) {
        String[] startArray = start.split(":");
        return Integer.valueOf(startArray[0]) * 60 + Integer.valueOf(startArray[1]);
    }

    static class Assignment implements Comparable<Assignment> {
        String name;
        int start;
        int playtime;

        public Assignment(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Assignment o) {
            return this.start - o.start;
        }
    }
}
