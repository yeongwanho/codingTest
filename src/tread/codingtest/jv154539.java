package tread.codingtest;

import java.util.ArrayDeque;
import java.util.Deque;

public class jv154539 {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                Integer peek = stack.peekLast();
                if (numbers[i] < peek) {
                    answer[i] = stack.peekLast();
                    break;
                } else {
                    stack.pollLast();
                }
            }
            if (answer[i] == 0) {
                answer[i] = -1;
            }

            stack.offerLast(numbers[i]);

        }
        System.out.println(answer);
    }
}
