package tread.codingtest;

import java.util.*;

public class jv176962 {
    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"math", "12:30", "40"}, {"english", "12:10", "20"}};
        Queue<Work> queue = new ArrayDeque<>();
        String[] answer = {};
        int num = 0;
        List<Work> list = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            Work plan = toPlan(plans[i]);
            list.add(plan);
        }
        list.sort(Comparator.comparing(item -> item.startTime));
        for (int i = 1; i < list.size(); i++) {
            while (!queue.isEmpty()){

            }
            if (list.get(i - 1).endTime < list.get(i).endTime) {
                answer[num] = list.get(i-1).work;
            }else {

            }

        }
        System.out.println(answer.toString());
    }

    private static Work toPlan(String[] plans) {
        String name = plans[0];
        String[] split = plans[1].split(":");
        int start = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
        int end = start + Integer.parseInt(plans[2]);
        Work work = new Work(name, start, end);
        return work;
    }

    public static class Work {
        private String work;
        private int startTime;
        private int endTime;

        public Work(String work, int startTime, int endTime) {
            this.work = work;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
